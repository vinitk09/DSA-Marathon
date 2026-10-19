// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Capacity lies in [max(weights), sum(weights)]. Greedily fill each day in order.
// Larger capacity never needs more days, giving false-then-true feasibility.
// Keep mid if feasible; otherwise discard it. The interval strictly shrinks.
// Time: O(n log(sum(weights) - max(weights) + 1)). Extra space: O(1).
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight; // LeetCode constraints bound the sum to 25,000,000.
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid, days)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int usedDays = 1, load = 0;
        for (int weight : weights) {
            if (load + weight > capacity) {
                usedDays++;
                load = 0;
                if (usedDays > days) return false;
            }
            load += weight;
        }
        return true;
    }
}
