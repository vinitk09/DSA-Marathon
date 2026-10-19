// https://leetcode.com/problems/reverse-linked-list/
// LeetCode provides ListNode with int val, ListNode next and standard constructors.
// Save next before reversing the link: prev <- current   next -> remaining.
// prev is the reversed prefix; current is the first unprocessed node.
// Time: O(n). Extra space: O(1). Reuses and modifies the input nodes.
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
