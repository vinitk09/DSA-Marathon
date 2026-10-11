// https://leetcode.com/problems/next-permutation/
// Find the rightmost rising pair, swap its pivot with the next larger value,
// then reverse the descending suffix to make it as small as possible.
// Time: O(n). Extra space: O(1).
class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
        if (pivot >= 0) {
            int successor = nums.length - 1;
            while (nums[successor] <= nums[pivot]) successor--;
            swap(nums, pivot, successor);
        }
        int left = pivot + 1, right = nums.length - 1;
        while (left < right) swap(nums, left++, right--);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
