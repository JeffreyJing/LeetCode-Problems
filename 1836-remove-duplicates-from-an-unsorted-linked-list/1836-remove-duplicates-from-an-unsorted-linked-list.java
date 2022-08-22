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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Set<Integer> allVals = new HashSet<Integer>();
        Set<Integer> duplicates = new HashSet<Integer>();
        ListNode current = head;
        while (current != null) {
            if (allVals.contains(current.val)) {
                duplicates.add(current.val);
            }
            
            allVals.add(current.val);
            current = current.next;
        }
        
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;
        while (head != null) {
            if (duplicates.contains(head.val)) {
                pred.next = head.next;
            } else {
                pred = head;
            }
            head = head.next;
        }
                
        return sentinel.next;
    }
}