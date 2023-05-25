class Node {
    int data;
    Node next;
    Node previous;
}

class CircularDoublyLL {
    Node head;
    Node tail;
   
    void insertAtFirst(int value) {
        if(head==null) {
            Node n = new Node();
            n.data = value;
            n.next = n.previous = null;
            head=tail = n;
        } else {
            Node n = new Node();
            n.data = value;
            n.next = head;
			if(head == tail) {
				tail.previous = n;
			}
            head = n;
            head.previous = tail;
            tail.next = head;
        }
	}
   
    void displayList() {
        Node current = head;
        if(current!=null) {
            do {
                System.out.print(current.data+"\t");
                current = current.next;
            } while(current!=head);
        }
        System.out.println();
    }
	
    public static void main(String[] args) {          
        CircularDoublyLL t = new CircularDoublyLL();
        t.insertAtFirst(10);
        t.insertAtFirst(20);
        t.insertAtFirst(30);
		t.insertAtFirst(40);
        t.displayList();
       
    }  
}