import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
// Traverse the four boundaries and shrink them after each side.
// Check remaining boundaries to avoid repeating a single row or column.
// Time: O(m * n). Extra space: O(1), excluding the output.
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) answer.add(matrix[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) answer.add(matrix[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) answer.add(matrix[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) answer.add(matrix[i][left]);
                left++;
            }
        }
        return answer;
    }
}
