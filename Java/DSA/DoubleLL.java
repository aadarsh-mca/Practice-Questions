package DSA;

class DNode {
    DNode previous;
    int data;
    DNode next;
}

public class DoubleLL {
    DNode head;
    DNode tail;

    void insertAtBegin(int data) {
        DNode n = new DNode();
        n.data = data;
        n.previous = null;
        if(head == null) {
            n.next = null;
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.previous = n;
            head = n;
        }
    }

    void insertAtEnd(int data) {
        DNode n = new DNode();
        n.data = data;
        n.next = null;
        if(head == null) {
            n.previous = null;
            head = n;
            tail = n;
        } else {
            n.previous = tail;
            tail.next = n;
            tail = n;
        }
    }

    void deleteFromHead() {
        if(head == null) {
            System.out.println("Empty Linked List");
        } else if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
    }

    void deleteFromTail() {
        if(head == null) {
            System.out.println("Empty Linked List");
        } else if(head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
    }

    void displayFromHead() {
        if(head == null) {
            System.out.println("Empty Linked List");
            return;
        }
        DNode curr = head;
        while(curr.next != null) {
            System.out.print(curr.data + " --> ");
            curr = curr.next;
        }
        System.out.println(curr.data + " --> NULL");
    }

    void displayFromTail() {
        if(tail == null) {
            System.out.println("Empty Linked List");
            return;
        }
        DNode curr = tail;
        while(curr.previous != null) {
            System.out.print(curr.data + " --> ");
            curr = curr.previous;
        }
        System.out.println(curr.data);
    }

    public static void main(String[] args) {
        DoubleLL obj = new DoubleLL();
        obj.insertAtBegin(10);
        obj.insertAtBegin(20);
        obj.insertAtBegin(30);
        obj.insertAtBegin(40);
        obj.insertAtEnd(50);
        obj.insertAtEnd(60);
        obj.insertAtEnd(70);
        obj.insertAtEnd(80);

        obj.displayFromHead();
        obj.displayFromTail();
        
        obj.deleteFromHead();

        obj.displayFromHead();
        obj.displayFromTail();

        obj.deleteFromTail();

        obj.displayFromHead();
        obj.displayFromTail();

        obj.reverseLinkedList();
    }

    void reverseLinkedList() {
        // DNode temp;
        // temp = head;
        // temp.previous = tail.previous;
        // head = tail;
        // head.previous = null;
        // head.next = temp.next;
        // tail = temp;
        // tail.next = null;

        displayFromHead();
        displayFromTail();
    }

}
