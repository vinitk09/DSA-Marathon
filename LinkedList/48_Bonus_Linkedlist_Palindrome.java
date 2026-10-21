/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while(head != null){
            result.add(head.val);
            head = head.next;
        }

        int low = 0;
        int high = result.size() - 1;
        while(low < high){
            if(result.get(low) != result.get(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}