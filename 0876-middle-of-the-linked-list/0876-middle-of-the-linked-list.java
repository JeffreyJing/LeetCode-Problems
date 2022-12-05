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
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode current = head;
        ListNode faster = head.next;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            current = current.next;
        }
        
        if (faster == null) {
            return current;
        } else {
            return current.next;
        }
    }
}