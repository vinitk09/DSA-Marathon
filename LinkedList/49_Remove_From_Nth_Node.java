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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) return null;
        int newsize = 0;
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }

        newsize = count - n;
        // The node to remove is the head.
        if (newsize == 0) return head.next;

        current = head;
        for(int i = 0; i < newsize - 1; i++){
            current = current.next;
        }
        if(current.next != null)
        current.next = current.next.next;

        return head;

    }
}