import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
// Sort, fix one value, and find pairs with two pointers; skip duplicate values.
// Sorting modifies nums. Time: O(n^2). Extra space: O(log n) for sorting,
// excluding the output.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int leftValue = nums[left], rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) left++;
                    while (left < right && nums[right] == rightValue) right--;
                }
            }
        }
        return answer;
    }
}
