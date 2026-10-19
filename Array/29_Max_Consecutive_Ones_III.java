// https://leetcode.com/problems/max-consecutive-ones-iii/
// A window is valid when it contains at most k zeroes; shrink until valid.
// Both pointers only move forwards. Time: O(n). Extra space: O(1).
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeroes = 0, best = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroes++;
            while (zeroes > k) {
                if (nums[left++] == 0) zeroes--;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
