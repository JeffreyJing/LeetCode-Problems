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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode current) {
        // empty LinkedList or single link case
        if (current == null || current.next == null) {
            return current;
        }
        
        // break the current LinkedList into two.
        ListNode middle = getMiddle(current);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        ListNode left = mergeSort(current);
        ListNode right = mergeSort(nextOfMiddle);
        ListNode sortedList = sortedMerge(left, right);
        return sortedList;
    }
    
    private ListNode sortedMerge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        
        if (right == null) {
            return left;
        }
        
        ListNode result = null;
        if (left.val <= right.val) {
            result = left;
            result.next = sortedMerge(left.next, right);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        
        return result;
    }
    
    private ListNode getMiddle(ListNode head) {
        if (head != null) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            
            return slow;
        }
        
        return head;
    }
}