// https://leetcode.com/problems/rotate-array/
// Reverse the whole array, then each of the two parts.
// Time: O(n). Extra space: O(1).
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) return;
        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
