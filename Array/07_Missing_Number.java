// https://leetcode.com/problems/missing-number/
// XOR cancels matching numbers, leaving the missing value.
// Time: O(n). Extra space: O(1).
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) missing ^= i ^ nums[i];
        return missing;
    }
}
