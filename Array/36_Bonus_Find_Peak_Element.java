// https://leetcode.com/problems/find-peak-element/
// Adjacent values differ and outside neighbors are negative infinity.
// Follow the rising slope: a peak exists in that direction. If falling, retain
// mid and the left side. [left, right] shrinks and retains at least one peak.
// Time: O(log n). Extra space: O(1).
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
