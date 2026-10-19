// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Find first >= target and first > target using half-open intervals [left, right).
// right = mid or left = mid + 1 strictly shrinks the interval, even with duplicates.
// Time: O(log n). Extra space: O(1).
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = boundary(nums, target, false);
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        return new int[]{first, boundary(nums, target, true) - 1};
    }

    private int boundary(int[] nums, int target, boolean upper) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target || (upper && nums[mid] == target)) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
