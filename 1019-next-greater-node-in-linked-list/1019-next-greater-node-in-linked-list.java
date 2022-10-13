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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> listCopy = new ArrayList<Integer>();
        while (head != null) {
            listCopy.add(head.val);
            head = head.next;
        }
        
        Stack<Integer> storage = new Stack<Integer>();
        int[] result = new int[listCopy.size()];
        for (int i = listCopy.size() - 1; i >= 0; i--) {
            if (storage.size() == 0) {
                result[i] = 0;
            } else if (storage.size() != 0 && storage.peek() > listCopy.get(i)) {
                result[i] = storage.peek();
            } else {
                while (storage.size() != 0 && storage.peek() <= listCopy.get(i)) {
                    storage.pop();
                }
                
                if (storage.isEmpty()) {
                    result[i] = 0;
                } else {
                    result[i] = storage.peek();
                }
            }
            
            storage.push(listCopy.get(i));
        }
        
        return result;
    }
}
/*
7
5
*/