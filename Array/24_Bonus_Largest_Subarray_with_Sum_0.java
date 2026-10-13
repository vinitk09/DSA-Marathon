import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
// Equal prefix sums delimit a zero-sum subarray. Keep each prefix's first index.
// Time: O(n) expected. Extra space: O(n).
class Solution {
    public int maxLen(int[] arr) {
        Map<Long, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0L, -1);
        long prefix = 0;
        int longest = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];
            Integer first = firstIndex.get(prefix);
            if (first != null) longest = Math.max(longest, i - first);
            else firstIndex.put(prefix, i);
        }
        return longest;
    }
}
