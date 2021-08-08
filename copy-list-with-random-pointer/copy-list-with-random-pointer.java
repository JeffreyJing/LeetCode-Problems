/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head != null) {
            Node current = head;
            Node newHead = new Node(head.val);
            Node newCurrent = newHead;
            if (head.next == null) {
                if (head.random != null) {
                    newHead.random = newHead;
                }
                return newHead;    
            }
            
            List<Node> originalList = new ArrayList<Node>();
            List<Node> newList = new ArrayList<Node>();
            while (current.next != null) {
                newCurrent.next = new Node(current.next.val);
                originalList.add(current);
                newList.add(newCurrent);
                current = current.next;
                newCurrent = newCurrent.next;
            }
            
            Node last = new Node(current.val);
            newList.get(newList.size() - 1).next = last;
            newList.add(last);
            originalList.add(current);
            originalList.add(null);
            newList.add(null);
            
            printList(originalList);
            printList(newList);
            for (int i = 0; i < originalList.size(); i++) {
                if (newList.get(i) != null) {
                    newList.get(i).random = newList.get(originalList.indexOf(originalList.get(i).random));
                }
            }

            return newHead;
        }
        
        return head;
    }
    
    private void printList(List<Node> list) {
        for (Node link : list) {
            if (link == null) {
                System.out.print(" null ");
            } else {
                System.out.print(link + " ");
            }
        }
        
        System.out.println();
    }
    
    
}