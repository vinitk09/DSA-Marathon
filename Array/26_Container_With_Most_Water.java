// https://leetcode.com/problems/container-with-most-water/
// Move the shorter side: keeping it while reducing width cannot improve the area.
// Time: O(n). Extra space: O(1).
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, best = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            best = Math.max(best, area);
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return best;
    }
}
