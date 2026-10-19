// https://leetcode.com/problems/search-a-2d-matrix-ii/
// Rows and columns are sorted separately; flattening is NOT necessarily sorted.
// From top-right: too large discards a column, too small discards a row.
// The candidate rectangle strictly shrinks on each mismatch.
// Time: O(rows + cols). Extra space: O(1).
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
