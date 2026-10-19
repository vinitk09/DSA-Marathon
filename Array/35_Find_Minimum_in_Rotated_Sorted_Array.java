// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Distinct values. Minimum stays in [left, right]. If mid > right, the rotation
// point is strictly after mid; otherwise mid may be the minimum, so retain it.
// With left < right, mid < right: either update strictly shrinks the interval.
// Time: O(log n). Extra space: O(1).
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
