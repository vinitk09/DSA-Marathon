import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
// Expand only from values with no predecessor; each distinct value is visited once.
// Time: O(n) expected. Extra space: O(n).
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) values.add(num);
        int longest = 0;
        for (int num : values) {
            if (num != Integer.MIN_VALUE && values.contains(num - 1)) continue;
            int current = num, length = 1;
            while (current != Integer.MAX_VALUE && values.contains(current + 1)) {
                current++;
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
