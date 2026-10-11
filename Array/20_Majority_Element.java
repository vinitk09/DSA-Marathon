// https://leetcode.com/problems/majority-element/
// Boyer-Moore voting: cancel pairs of different values.
// The problem guarantees a majority, so the surviving candidate is the answer.
// Time: O(n). Extra space: O(1).
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}
