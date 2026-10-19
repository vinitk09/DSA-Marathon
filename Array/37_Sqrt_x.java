// https://leetcode.com/problems/sqrtx/
// Search [1, x] for the largest feasible mid: mid*mid <= x (true then false).
// Use long multiplication to avoid overflow. Each update discards mid.
// Time: O(log x) for x >= 2. Extra space: O(1).
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1, right = x, answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                answer = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return answer;
    }
}
