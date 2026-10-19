// https://leetcode.com/problems/search-in-rotated-sorted-array/
// Values are distinct, so at least one half is sorted. Keep the half that can
// contain target. Discard mid after checking it, shrinking [left, right].
// Time: O(log n). Extra space: O(1).
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
