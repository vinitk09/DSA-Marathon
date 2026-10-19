"""Compile and exercise the 18 independent LeetCode Java submissions."""
from pathlib import Path
import os
import shutil
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parents[1]


def java_bin(name):
    found = shutil.which(name)
    if found:
        return found
    candidates = []
    if os.environ.get('JAVA_HOME'):
        candidates.append(Path(os.environ['JAVA_HOME']) / 'bin' / (name + '.exe'))
    candidates.extend((Path.home() / '.vscode/extensions').glob(
        'redhat.java-*/jre/*/bin/' + name + '.exe'))
    for candidate in candidates:
        if candidate.is_file():
            return str(candidate)
    raise RuntimeError('Install a JDK or set JAVA_HOME; cannot find ' + name)


HARNESS = r'''
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
public class MarathonTests {
    static int checks;
    static void eq(Object actual, Object expected) {
        checks++;
        if (!Objects.deepEquals(actual, expected))
            throw new AssertionError("Check " + checks + ": " + actual + " != " + expected);
    }
    static ListNode list(int... values) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int value : values) { tail.next = new ListNode(value); tail = tail.next; }
        return dummy.next;
    }
    static int[] values(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            if (result.size() > 1000) throw new AssertionError("Possible list cycle");
            result.add(head.val); head = head.next;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    static String bruteWindow(String s, String t) {
        String best = "";
        for (int i = 0; i < s.length(); i++) {
            int[] counts = new int[128];
            for (int j = i; j < s.length(); j++) {
                counts[s.charAt(j)]++;
                int[] required = new int[128];
                for (char c : t.toCharArray()) required[c]++;
                boolean ok = true;
                for (int c = 0; c < 128; c++) if (counts[c] < required[c]) ok = false;
                if (ok && (best.isEmpty() || j-i+1 < best.length())) best = s.substring(i,j+1);
            }
        }
        return best;
    }
    public static void main(String[] args) {
        eq(new S28().lengthOfLongestSubstring("abba"), 2);
        eq(new S28().lengthOfLongestSubstring(""), 0);
        eq(new S29().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2), 6);
        eq(new S29().longestOnes(new int[]{0,0}, 0), 0);
        eq(new S30().minWindow("ADOBECODEBANC", "ABC"), "BANC");
        eq(new S30().minWindow("AAAB", "AAB"), "AAB");
        eq(new S30().minWindow("a", "aa"), "");
        eq(new S30().minWindow("", "a"), "");
        eq(new S30().minWindow("abc", ""), "");
        eq(new S31().search(new int[]{1}, 0), -1);
        eq(new S32().searchRange(new int[]{}, 0), new int[]{-1,-1});
        eq(new S32().searchRange(new int[]{2,2}, 2), new int[]{0,1});
        eq(new S33().singleNonDuplicate(new int[]{7}), 7);
        eq(new S37().mySqrt(Integer.MAX_VALUE), 46340);
        eq(new S38().minEatingSpeed(new int[]{3,6,7,11}, 8), 4);
        eq(new S38().minEatingSpeed(new int[]{1000000000,1000000000,1000000000}, 1000000000), 4);
        eq(new S39().shipWithinDays(new int[]{1,2,3,1,1}, 4), 3);
        eq(new S39().shipWithinDays(new int[]{1,2,3,1,1}, 1), 8);
        int[][] flat = {{1,3,5},{7,9,11}};
        eq(new S40().searchMatrix(flat, 9), true);
        eq(new S40().searchMatrix(flat, 6), false);
        eq(new S40().searchMatrix(new int[][]{}, 1), false);
        int[][] grid = {{1,4},{2,5}};
        eq(new S41().searchMatrix(grid, 2), true);
        eq(new S41().searchMatrix(grid, 3), false);
        eq(new S41().searchMatrix(new int[][]{{}}, 1), false);
        eq(new S42().findMedianSortedArrays(new int[]{}, new int[]{1}), 1.0);
        eq(new S42().findMedianSortedArrays(new int[]{Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE}), (double) Integer.MAX_VALUE);
        eq(values(new S43().reverseList(null)), new int[]{});
        ListNode one = list(7);
        eq(new S43().reverseList(one) == one, true);
        eq(values(new S43().reverseList(list(1,2,3))), new int[]{3,2,1});
        eq(new S44().middleNode(null), null);
        eq(new S44().middleNode(one) == one, true);
        eq(values(new S44().middleNode(list(1,2,3,4))), new int[]{3,4});
        eq(values(new S44().middleNode(list(1,2,3))), new int[]{2,3});
        eq(values(new S45().mergeTwoLists(null, null)), new int[]{});
        eq(values(new S45().mergeTwoLists(null, list(1))), new int[]{1});
        eq(values(new S45().mergeTwoLists(list(1), null)), new int[]{1});
        eq(values(new S45().mergeTwoLists(list(1,2,4), list(1,3,4))), new int[]{1,1,2,3,4,4});
        Random random = new Random(60);
        for (int trial = 0; trial < 300; trial++) {
            int n = 1 + random.nextInt(20);
            int[] sorted = new int[n];
            for (int i = 0; i < n; i++) sorted[i] = 2*i - 20;
            int rotation = random.nextInt(n);
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) rotated[i] = sorted[(i+rotation)%n];
            eq(new S35().findMin(rotated), sorted[0]);
            for (int target = -22; target < 22; target++) {
                int index = -1, rotatedIndex = -1;
                for (int i = 0; i < n; i++) {
                    if (sorted[i] == target) index = i;
                    if (rotated[i] == target) rotatedIndex = i;
                }
                eq(new S31().search(sorted, target), index);
                eq(new S34().search(rotated, target), rotatedIndex);
            }
            int[] duplicates = new int[n];
            for (int i = 0; i < n; i++) duplicates[i] = random.nextInt(6);
            Arrays.sort(duplicates);
            for (int target = -1; target <= 6; target++) {
                int first = -1, last = -1;
                for (int i = 0; i < n; i++) if (duplicates[i] == target) {
                    if (first == -1) first = i;
                    last = i;
                }
                eq(new S32().searchRange(duplicates, target), new int[]{first,last});
            }
            int singleton = random.nextInt(n);
            int[] pairs = new int[2*n-1];
            int p = 0;
            for (int i = 0; i < n; i++) {
                pairs[p++] = i;
                if (i != singleton) pairs[p++] = i;
            }
            eq(new S33().singleNonDuplicate(pairs), singleton);
            int peak = new S36().findPeakElement(rotated);
            eq((peak == 0 || rotated[peak] > rotated[peak-1]) &&
               (peak == n-1 || rotated[peak] > rotated[peak+1]), true);
            int x = random.nextInt(Integer.MAX_VALUE);
            int root = new S37().mySqrt(x);
            eq((long)root*root <= x && (long)(root+1)*(root+1) > x, true);
            int[] a = Arrays.copyOf(duplicates, random.nextInt(n+1));
            int[] b = sorted;
            int[] merged = new int[a.length+b.length];
            System.arraycopy(a,0,merged,0,a.length);
            System.arraycopy(b,0,merged,a.length,b.length);
            Arrays.sort(merged);
            double median = ((double)merged[(merged.length-1)/2] + merged[merged.length/2])/2;
            eq(new S42().findMedianSortedArrays(a,b), median);
            int[] piles = new int[n];
            int sum = 0, max = 0;
            for (int i = 0; i < n; i++) { piles[i] = 1+random.nextInt(20); sum += piles[i]; max = Math.max(max,piles[i]); }
            int h = n + random.nextInt(30), speed = 1;
            for (;; speed++) {
                int hours = 0;
                for (int pile : piles) hours += (pile+speed-1)/speed;
                if (hours <= h) break;
            }
            eq(new S38().minEatingSpeed(piles,h), speed);
            int days = 1+random.nextInt(n), capacity = max;
            for (; capacity <= sum; capacity++) {
                int used = 1, load = 0;
                for (int w : piles) { if (load+w > capacity) { used++; load=0; } load+=w; }
                if (used <= days) break;
            }
            eq(new S39().shipWithinDays(piles,days), capacity);
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) s.append((char)('A'+random.nextInt(4)));
            String text = s.toString(), t = trial%2 == 0 ? "AAB" : "BC";
            eq(new S30().minWindow(text,t), bruteWindow(text,t));
            int longest = 0;
            for (int i = 0; i < n; i++) {
                Set<Character> seen = new HashSet<>();
                for (int j = i; j < n && seen.add(text.charAt(j)); j++) longest = Math.max(longest,j-i+1);
            }
            eq(new S28().lengthOfLongestSubstring(text), longest);
            int[] bits = new int[n];
            for (int i = 0; i < n; i++) bits[i] = random.nextInt(2);
            int k = random.nextInt(n+1), best = 0;
            for (int i = 0; i < n; i++) {
                int zeros = 0;
                for (int j = i; j < n; j++) { if (bits[j] == 0) zeros++; if (zeros <= k) best = Math.max(best,j-i+1); }
            }
            eq(new S29().longestOnes(bits,k), best);
        }
        for (int x = 0; x <= 100; x++) eq(new S37().mySqrt(x), (int)Math.sqrt(x));
        System.out.println("Passed " + checks + " checks across all 18 solutions.");
    }
}
'''


def main():
    sources = ['import java.util.*;']
    for number in range(28, 46):
        folder = 'Array' if number <= 42 else 'LinkedList'
        matches = list((ROOT / folder).glob(str(number) + '_*.java'))
        if len(matches) != 1:
            raise RuntimeError(f'Expected one source for problem {number}: {matches}')
        source = matches[0].read_text(encoding='utf-8')
        source = '\n'.join(line for line in source.splitlines() if not line.startswith('import '))
        sources.append(source.replace('class Solution {', f'class S{number} {{', 1))
    sources.append(HARNESS)
    with tempfile.TemporaryDirectory(prefix='dsa-days-10-15-') as directory:
        source_path = Path(directory) / 'MarathonTests.java'
        source_path.write_text('\n'.join(sources), encoding='utf-8')
        subprocess.run([java_bin('javac'), '-encoding', 'UTF-8', str(source_path)], check=True)
        subprocess.run([java_bin('java'), '-cp', directory, 'MarathonTests'], check=True)


if __name__ == '__main__':
    main()
