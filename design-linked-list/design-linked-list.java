class MyLinkedList {

    private ListNode head;
    private int size;
    private ListNode tail;
    private int counter;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
        this.tail = null;
        this.counter = 1;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < this.size && index >= 0) {
            if (index == 0) {
                return this.head.val;
            }
            
            if (index == this.size - 1) {
                return this.tail.val;
            }
            
            ListNode current = this.head;
            while (index != 0) {
                current = current.next;
                index--;
            }
            
            return current.val;
        }
        
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = this.head;
        this.head = newHead;
        if (this.tail == null) {
            this.updateTail();
        }
        this.size++;
        this.verifyLength();
    }
    
    private void updateTail() {
        if (tail == null) {
            if (this.head != null) {
                ListNode current = this.head;
                while (current.next != null) {
                    current = current.next;
                }
                
                this.tail = current;
            }
        } else {
            while (tail.next != null) {
                tail = tail.next;
            }
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.tail != null) {
            this.tail.next = new ListNode(val);
            this.tail = this.tail.next;
        } else if (this.head == null) {
            this.head = new ListNode(val);
            this.tail = new ListNode(val);
        }
        
        this.size++;
        this.verifyLength();
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= this.size && index >= 0) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == this.size) {
                addAtTail(val);
            } else {
                ListNode current = this.head;
                while (index >= 2) {
                    current = current.next;
                    index--;
                }

                ListNode insertedNode = new ListNode(val);
                insertedNode.next = current.next;
                current.next = insertedNode;
                this.size++;
            }
        }
        
        this.verifyLength();
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (isValidIndex(index)) {
            if (index == 0 && this.size == 1) {
                this.head = null;
                this.tail = null;
            } else if (index == 0) {
                this.head = this.head.next;
            } else {
                ListNode previous = this.getNodeAtIndex(index - 1);
                previous.next = previous.next.next;
                if (this.size - 1 == index) {
                    this.tail = previous;
                }
            }
            
            this.size--;
        }
        
        this.verifyLength();
    }
    
    private ListNode getNodeAtIndex(int index) {
        ListNode current = this.head;
        while (index != 0) {
            current = current.next;
            index--;
        }
        
        return current;
    }
    
    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.size;
    }
    
    private void verifyLength() {
        int count = 0;
        ListNode current = this.head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        if (count > this.size) {
            System.out.println(counter + ": size is too small");
        } else if (count < this.size) {
            System.out.println(counter + ": size is too big by " + (this.size - count));
        } else {
            System.out.println(counter + ": size is correct");
        }
        
        counter++;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */