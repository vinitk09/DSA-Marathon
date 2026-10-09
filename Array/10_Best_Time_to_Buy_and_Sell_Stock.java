// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Track the cheapest price so far and best profit from one transaction.
// Time: O(n). Extra space: O(1).
class Solution {
    public int maxProfit(int[] prices) {
        int minimumPrice = Integer.MAX_VALUE, bestProfit = 0;
        for (int price : prices) {
            minimumPrice = Math.min(minimumPrice, price);
            bestProfit = Math.max(bestProfit, price - minimumPrice);
        }
        return bestProfit;
    }
}
