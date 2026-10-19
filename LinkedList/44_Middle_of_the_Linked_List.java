// https://leetcode.com/problems/middle-of-the-linked-list/
// LeetCode provides ListNode. Move slow once and fast twice per iteration.
// When fast reaches the end, slow is at the middle (second middle for even n).
// Time: O(n). Extra space: O(1). Empty input returns null.
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
