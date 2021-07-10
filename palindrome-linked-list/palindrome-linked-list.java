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
        ListNode current = head;
        Stack<ListNode> nodes = new Stack<ListNode>();
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        
        current = head;
        while (!nodes.isEmpty()) {
            ListNode popped = nodes.pop();
            if (current.val != popped.val) {
                return false;
            }
            
            current = current.next;
        }
        
        return true;
    }
}