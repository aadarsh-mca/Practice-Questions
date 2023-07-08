package DSA;

class CSNode {
    int data;
    CSNode next;
}

class CDNode {
    CDNode previous;
    int data;
    CDNode next;
}

public class LLCircular {
    CSNode sHead;
    CSNode sTail;

    void insertFromBegin(int data) {
        CSNode sN = new CSNode();
    
        sN.data = data;
        if(sHead == null) {
            sN.next = null;
            sHead = sN;
            sTail = sN;
        } else {
            sN.next = sHead;
            sHead = sN;
            sTail.next = sHead;
        }

        // CDNode dN = new CDNode();

        // dN.data = data;
    }

    void insertFromEnd(int data) {
        CSNode sN = new CSNode();

        sN.data = data;
        if(sHead == null) {
            sN.next = null;
            sHead = sN;
            sTail = sN;
        }  else {
            sN.next = sHead;
            sTail.next = sN;
            sTail = sN;
        }
    }
    
    void displayFromBegin() {
        CSNode curr = sHead;

        if(curr != null) {
            do {
                System.out.print(curr.data + " --> ");
                curr = curr.next;
            } while(curr.next != sHead);
            System.out.println(curr.data + " --> sHead");
        } else {
            System.out.println("Empty Linked List");
        }
    }

    void displayFromEnd() {
    }
    
    public static void main(String[] args) {
        LLCircular obj = new LLCircular();

        obj.insertFromBegin(10);
        obj.insertFromBegin(20);
        obj.insertFromBegin(30);
        obj.insertFromEnd(50);
        obj.insertFromEnd(60);
        obj.insertFromEnd(70);

        obj.displayFromBegin();
        
    }
}
