import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
// Count earlier prefix sums equal to the current prefix minus k.
// Seed the empty prefix to count subarrays starting at index zero.
// Time: O(n) expected. Extra space: O(n).
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        frequencies.put(0, 1);
        int prefix = 0, count = 0;
        for (int num : nums) {
            prefix += num;
            count += frequencies.getOrDefault(prefix - k, 0);
            frequencies.put(prefix, frequencies.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
