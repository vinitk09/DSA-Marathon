// https://leetcode.com/problems/set-mismatch/
// Mark visited indices negative, find the unmarked index, then restore input.
// Time: O(n). Extra space: O(1), excluding the returned array.
class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1, missing = -1;
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]);
            if (nums[value - 1] < 0) duplicate = value;
            else nums[value - 1] = -nums[value - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) missing = i + 1;
            nums[i] = Math.abs(nums[i]);
        }
        return new int[] {duplicate, missing};
    }
}
