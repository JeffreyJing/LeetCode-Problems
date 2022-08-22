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
    
    /*
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            
            head = head.next;
        }
        
        return sentinel.next;
    } */
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head.next;
        ListNode prev = head;
        ListNode uniques = null;
        ListNode uniquesCurrent = uniques;
        while (prev != null && current != null) {
            if (prev.val == current.val) {
                prev = findNextVal(current);
                if (prev == null) {
                    return uniques;
                }
                
                current = prev.next;
            } else {
                if (uniques == null) {
                    uniques = prev;
                    uniques.next = null;
                    uniquesCurrent = uniques;
                } else {
                    uniquesCurrent.next = prev;
                    uniquesCurrent = uniquesCurrent.next;
                    uniquesCurrent.next = null;
                }
                
                prev = current;
                current = current.next;
            }
        }
        
        if (uniquesCurrent == null) {
            return prev;
        }
        
        if (prev.val != uniquesCurrent.val) {
            uniquesCurrent.next = prev;
            uniquesCurrent.next.next = null;
        } else {
            uniquesCurrent.next = null;
        }
        
        return uniques;
    }
    
    private ListNode findNextVal(ListNode current) {
        while (current != null && current.next != null) {
            if (current.val != current.next.val) {
                return current.next;
            } else {
                current = current.next;
            }
        }
        
        return null;
    }
}