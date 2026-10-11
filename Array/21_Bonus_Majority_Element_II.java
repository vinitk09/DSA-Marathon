import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/
// At most two values can occur more than n / 3 times.
// Cancel triples of distinct values, then verify both surviving candidates.
// Time: O(n). Extra space: O(1), including the at-most-two-element output.
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        List<Integer> answer = new ArrayList<>();
        if (count1 > nums.length / 3) answer.add(candidate1);
        if (count2 > nums.length / 3) answer.add(candidate2);
        return answer;
    }
}
