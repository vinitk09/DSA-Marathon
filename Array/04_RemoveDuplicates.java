// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Two pointers. Time: O(n). Extra space: O(1).
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) nums[write++] = nums[read];
        }
        return write;
    }
}
