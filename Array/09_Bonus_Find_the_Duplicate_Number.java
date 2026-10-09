// https://leetcode.com/problems/find-the-duplicate-number/
// Floyd's cycle detection: the cycle entry is the duplicate.
// Time: O(n). Extra space: O(1). Does not modify the input.
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
