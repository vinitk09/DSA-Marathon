import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
// Each interior value is the sum of its two parents in the previous row.
// Time: O(numRows^2). Extra space: O(numRows^2), including the output.
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(triangle.get(i - 1).get(j - 1)
                        + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }
}
