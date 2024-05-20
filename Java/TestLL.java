public class TestLL {
    static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    public static void main(String[] args) {
        // int[] arr = {6,5,3,4,7,1,2};
        // int[] arr = {1,2,3,4,5};
        // int[] arr = {1,2,3,4,5,6};
        // int[] arr = {1,2,3,4,5,6,7,8,9};
        // int[] arr = {1,2};
        // int[] arr = {1};
        int[] arr = {6,4,2,5,1,3};
        Node head = createLL(arr);
        System.out.println("Before : ");
        printLL(head);
        
        
        // System.out.println("After : ");
        // printLL(segregateEvenOdd(head));
        
        // printLL(oddEvenList(head));


        // printLL(removeNthFromEnd(head, 3));


        printLL(sortList(head));

    }

    static Node sortList(Node head) {
        if(head == null || head.next == null) return head;

        Node midNode = findMidNode(head);
        System.out.println(midNode.data);

        Node leftHead = head;
        Node rightHead = midNode.next;
        midNode.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeLL(leftHead, rightHead);
    }

    static Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node mergeLL(Node leftHead, Node rightHead) {
        Node tempHead = new Node(-1);
        Node tempTail = tempHead;
        while(leftHead != null && rightHead != null) {
            if(leftHead.data < rightHead.data) {
                tempTail.next = leftHead;
                tempTail = tempTail.next;
                leftHead = leftHead.next;
            } else {
                tempTail.next = rightHead;
                tempTail = tempTail.next;
                rightHead = rightHead.next;
            }
        }

        if(leftHead != null) {
            tempTail.next = leftHead;
        } else {
            tempTail.next = rightHead;
        }

        return tempHead.next;
    }



    public static Node segregateEvenOdd(Node head) {
        if (head == null)
            return null;
        if (head.next == null || head.next.next == null)
            return head;

        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            if(evenHead == null && curr.data % 2 == 0) {
                evenHead = newNode;
                evenTail = newNode;
            } else if(oddHead == null && curr.data % 2 != 0) {
                oddHead = newNode;
                oddTail = newNode;
            } else {
                if(curr.data % 2 == 0) {
                    evenTail.next = newNode;
                    evenTail = evenTail.next;
                } else {
                    oddTail.next = newNode;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
        }

        evenTail.next = oddHead;
        return evenHead;
    }


    static Node oddEvenList(Node head) {
        if(head == null) return null;
        if(head.next == null || head.next.next == null) return head;

        Node oddHead = head;
        Node oddTail = head;
        Node evenHead = head.next;
        Node evenTail = head.next;

        Node curr = head;
        while(curr != null && curr.next != null) {
            curr = curr.next.next;
            if(curr != null) {
                oddTail.next = curr;
                oddTail = oddTail.next;
                
                evenTail.next = curr.next;
                evenTail = evenTail.next;
            }
        }

        oddTail.next = evenHead;
        return oddHead;
    }

    static Node removeNthFromEnd(Node head, int n) {
        if(head.next == null) return null;

        int count = 0;
        Node fast = head;
        while(count != n-1 && fast != null) {
            count++;
            fast = fast.next;
        }

        Node prev = head;
        Node slow = head;
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next;
        // slow.next = slow.next.next;
        return head;
    }









    

    static Node createLL(int[] arr) {
        Node head = null;
        Node tail = null;
        for(int num : arr) {
            Node newNode = new Node(num);
            if(head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    static void printLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

}
