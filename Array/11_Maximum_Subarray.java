// https://leetcode.com/problems/maximum-subarray/
// Kadane's algorithm: extend the previous subarray or start at this value.
// Time: O(n). Extra space: O(1).
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0], bestSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
