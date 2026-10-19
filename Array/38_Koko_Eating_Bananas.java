// https://leetcode.com/problems/koko-eating-bananas/
// Speed is in [1, max(piles)] since h >= piles.length. More speed never increases
// required hours: feasibility changes from false to true. Keep the first true.
// right = mid retains a feasible candidate; left = mid + 1 rejects a failure.
// Time: O(n log max(piles)). Extra space: O(1).
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) right = Math.max(right, pile);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + (long) speed - 1) / speed;
            if (hours > h) return false;
        }
        return true;
    }
}
