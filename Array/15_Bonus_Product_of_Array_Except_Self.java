// https://leetcode.com/problems/product-of-array-except-self/
// Store products to the left in the output, then multiply by products to the right.
// No division; zero values need no special handling.
// Time: O(n). Extra space: O(1), excluding the output.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }
}
