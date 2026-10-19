// https://leetcode.com/problems/single-element-in-a-sorted-array/
// Before the singleton, pairs start at even indices. Align mid to an even index.
// A matching pair excludes everything through mid + 1; otherwise retain mid.
// [left, right] always contains the singleton and strictly shrinks.
// Time: O(log n). Extra space: O(1).
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) left = mid + 2;
            else right = mid;
        }
        return nums[left];
    }
}
