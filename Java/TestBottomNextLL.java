public class TestBottomNextLL {
    static class Node {
        int data;
        Node bottom;
        Node next;

        Node(int data) {
            this.data = data;
            this.bottom = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{5,7,8,30}, {10,20,30}, {19,22,50}, {28,35,40,45}};

        Node root = createBottomNextLL(arr);
        printLL(root);

        System.out.println();
        flatten(root);

        System.out.println();
        printStraightLL(root);
    }

    /**
     * 
     *  5  10  19  28
     *  7  20  22  35
     *  8  30  50  40
     * 30          50
     * 
     */
    
    static Node flatten(Node root) {
        // code here
        if(root == null) {
            return null;
        }

        Node prevMerged = flatten(root.next);

        Node newSortedMerged = merge2BottomList(root, prevMerged);
        // printStraightLL(newSortedMerged);

        return newSortedMerged;
    }

    static Node merge2BottomList(Node head1, Node head2) {
        Node dummyHead = new Node(-1);
        Node dummyTail = dummyHead;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                dummyTail.bottom = head1;
                head1 = head1.bottom;
            } else {
                dummyTail.bottom = head2;
                head2 = head2.bottom;
            }
            dummyTail = dummyTail.bottom;
        }

        if(head1 != null) {
            dummyTail.bottom = head1;
        }

        if(head2 != null) {
            dummyTail.bottom = head2;
        }

        return dummyHead.bottom;
    }


    







    /**
     * Driver Code
     */

    static Node createBottomNextLL(int[][] arr) {
        Node dummyHead = new Node(0);
        Node dummyTail = dummyHead;

        for(int[] tempArr : arr) {
            Node dummyBottomHead = new Node(0);
            Node dummyBottomTail = dummyBottomHead;

            for(int num : tempArr) {
                Node temp = new Node(num);
                dummyBottomTail.bottom = temp;
                dummyBottomTail = dummyBottomTail.bottom;
            }

            dummyTail.next = dummyBottomHead.bottom;
            dummyTail = dummyTail.next;
        }

        return dummyHead.next;
    }

    static void printLL(Node root) {
        Node curr = root;
        
        while(curr != null) {
            Node bottom = curr;
            while(bottom != null) {
                System.out.print(bottom.data + " ");
                bottom = bottom.bottom;
            }
            System.out.println();

            curr = curr.next;
        }
    }

    static void printStraightLL(Node root) {
        while(root != null) {
            System.out.print(root.data + " ");
            root = root.bottom;
        }
    }
}
