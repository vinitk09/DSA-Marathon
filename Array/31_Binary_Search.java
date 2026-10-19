// https://leetcode.com/problems/binary-search/
// If present, target stays in the inclusive interval [left, right].
// After a mismatch, discard mid and one half; the interval strictly shrinks.
// Time: O(log n). Extra space: O(1).
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
