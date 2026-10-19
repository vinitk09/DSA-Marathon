// https://leetcode.com/problems/merge-two-sorted-lists/
// LeetCode provides ListNode with int val, ListNode next and standard constructors.
// Append the smaller head to tail; advance the selected list and tail.
// Once a list ends, attach the remaining sorted suffix.
// Time: O(m+n). Extra space: O(1). Reuses and modifies the input nodes.
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
