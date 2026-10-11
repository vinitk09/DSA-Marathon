import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
// Look for the complement among earlier elements before saving this index.
// Time: O(n) expected. Extra space: O(n).
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer otherIndex = seen.get(target - nums[i]);
            if (otherIndex != null) return new int[] {otherIndex, i};
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two-sum solution exists");
    }
}
