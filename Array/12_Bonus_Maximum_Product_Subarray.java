// https://leetcode.com/problems/maximum-product-subarray/
// Track both extremes: a negative can turn the minimum into the maximum.
// Time: O(n). Extra space: O(1).
class Solution {
    public int maxProduct(int[] nums) {
        int maxEnding = nums[0], minEnding = nums[0], bestProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            if (value < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }
            maxEnding = Math.max(value, maxEnding * value);
            minEnding = Math.min(value, minEnding * value);
            bestProduct = Math.max(bestProduct, maxEnding);
        }
        return bestProduct;
    }
}
