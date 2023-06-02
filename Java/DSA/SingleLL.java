package DSA;

class Node {
    int data;
    Node next;
}

public class SingleLL {
    Node head;
    Node tail;

    void insertAtBegin(int data) {
        Node n = new Node();
        n.data = data;
        if(head == null) {
            n.next = null;
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    void insertAtEnd(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if(head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    void insertInMiddle(int data, int position) {
    }

    void deleteAtBegin() {
        if(head == null) {
            System.out.println("Empty Linked List");
        } else if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    void deleteAtEnd() {
        Node curr = head;
        if(head == null) {
            System.out.println("Empty Linked List");
        } else if(head == tail) {
            head = tail = null;
        } else {
            while(curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
        }

    }

    // boolean isSingleNode() {
    //     return head == tail ? true : false;
    // }
    
    void displayLL() {
        Node curr = head;
        if(head == null) {
            System.out.println("Empty Linked List");
        } else if(head == tail) {
            System.out.println(head.data + " --> NULL");
        } else {
            while(curr.next != null) {
                System.out.print(curr.data + " --> ");
                curr = curr.next;
            }
            System.out.println(curr.data + " --> NUll");
        }
    }

    public static void main(String[] args) {
        SingleLL obj = new SingleLL();
        obj.insertAtEnd(10);
        obj.insertAtEnd(20);
        obj.insertAtEnd(30);
        obj.insertAtEnd(40);
        obj.insertAtBegin(50);
        obj.insertAtBegin(60);
        obj.insertAtBegin(70);
        obj.insertAtBegin(80);

        obj.displayLL();
        
        obj.deleteAtEnd();
        obj.deleteAtEnd();

        obj.displayLL();

        obj.deleteAtBegin();
        obj.deleteAtBegin();

        obj.displayLL();
    }
}
