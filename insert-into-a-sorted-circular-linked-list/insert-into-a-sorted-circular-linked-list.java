/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    // break the linkedlist where it loops back to the head
    // insert the new node at its correct position
    // re-attach the linkedlist tail and head.
    public Node insert(Node head, int val) {
        // case where the given LinkedList is empty.
        if (head == null) {
            Node newHead = new Node(val);
            newHead.next = newHead;
            return newHead;
        }
        
        // if the LinkedList is size 1, we can attach the
        // new node directly and return head.
        if (head.next == null) {
            Node newNode = new Node(val);
            newNode.next = head.next;
            head.next = newNode;
        } else {
            Node front = head;
            Node end = head;
            while (end.next != front && end.next.val >= end.val) {
                end = end.next;
            }
            
            front = end.next;
            end.next = null;
            printList(front);
            // now, we have a regular sorted LinkedList.
            Node newNode = new Node(val);
            if (val <= front.val) {
                // if the new node belongs at the front of the list, put it at the front.
                newNode.next = front;
                front = newNode;
                // re-attach the end and the front
                end.next = front;
            } else if (val >= end.val) {
                // if the new node belongs at the end of the list, put it at the end.
                end.next = newNode;
                newNode.next = front;
            } else {
                // the new node belongs somewhere in the middle of the list.
                Node current = front;
                while (current.next.val < val) {
                    current = current.next;
                }
                
                newNode.next = current.next;
                current.next = newNode;
                end.next = front;
            }
            
        }
        
        return head;
    }
    
    private void printList(Node front) {
        Node current = front;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        
        System.out.print("null");
    }
}