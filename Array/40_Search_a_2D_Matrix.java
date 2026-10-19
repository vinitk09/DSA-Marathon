// https://leetcode.com/problems/search-a-2d-matrix/
// Rows are sorted AND each row starts after the previous row ends.
// Treat the matrix as one sorted array; flat index i maps to [i / cols][i % cols].
// Inclusive [left, right]; discard mid on each mismatch to ensure progress.
// Time: O(log(rows * cols)). Extra space: O(1).
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int cols = matrix[0].length, left = 0, right = matrix.length * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid / cols][mid % cols];
            if (value == target) return true;
            if (value < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
