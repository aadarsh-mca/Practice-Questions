import java.util.ArrayList;
import java.util.Arrays;

public class TestLL {
    static class Node {
        public int val;
        public Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public static void main(String[] args) {
        // int[] arr = {6,5,3,4,7,1,2};
        // int[] arr = {1,2,3,4,5};
        // int[] arr = {1,2,3,4,5,6};
        // int[] arr = {0,1,2};
        // int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr = {1,2};
        // int[] arr = {1};
        // int[] arr = {4,5,7};
        // int[] arr = {4,5,9};
        // int[] arr = {1,1,1,2,3,4};
        Node head = createLL(arr);
        System.out.println("Before : ");
        printLL(head);
        
        // removeDuplicates(head);

        System.out.println("After : ");
        // printLL(head);
        // printLL(reverseKGroup(head, 1));
        // printLL(rotateRight(head, 1));
        // printLL(reverseLL(head));
    }

    static Node addOne(Node head) {
        // if(head == null) {
        //     return null;
        // }
        // addOne(head.next);
        // head.val += 1;

        // if(head.val > 9) {
        //     head.val = 0;
        //     int carry = 1;
        // }

        int carry = addOneRecursive(head);
        if(carry > 0) {
            Node temp = new Node(carry);
            temp.next = head;
            head = temp;
        }

        return head;
    }

    static int addOneRecursive(Node head) {
        if(head == null) {
            return 0;
        }

        int carry = addOneRecursive(head.next);
        
        if(carry > 0) {
            head.val += carry;
            carry = 0;
        }
        
        if(head.next == null) {
            head.val += 1;
        }
        if(head.val > 9) {
            head.val = 0;
            carry = 1;
            return carry;
        }

        return 0;
    }





    static Node rotateRight(Node head, int k) {
        // O(n) for getting the length
        int len = lengthOfLL(head);
        if(k == 0 || len == 0 || len == 1) return head;

        k = k % len;
        if(k == len) return head;

        // here we divided the LL in 2 parts
        // i.e. (len - k) + (k) = len
        Node firstHead = head;
        Node curr = head;
        while(k > 0 && curr != null) {
            curr = curr.next;
            k--;
        }

        // head of second part of LL
        Node secondHead = curr.next;
        curr.next = null;

        // iterate to the end of second part of LL
        curr = secondHead;
        while(curr.next != null) {
            curr = curr.next;
        }

        // join the 
        // tail of second part -> head of first part
        curr.next = firstHead;

        // return the head of second part of LL
        // as the starting point of rotated LL
        return secondHead;
    }

    static int lengthOfLL(Node head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }






    static Node addTwoNumbers(Node l1, Node l2) {
        Node currL1 = l1;
        Node currL2 = l2;

        printLL(currL1);
        printLL(currL2);

        currL1 = reverseLL(currL1);
        currL2 = reverseLL(currL2);

        printLL(currL1);
        printLL(currL2);

        return l1;
    }

    static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }





    static ArrayList<Node> breakListInKGroup(Node head, int k) {
        ArrayList<Node> listNode = new ArrayList<>();

        Node start = head;
        Node curr = head;
        int count = 1;
        while(curr != null) {
            Node next = curr.next;

            if(count == k) {
                curr.next = null;
                listNode.add(reverseLL(start));
                start = curr = next;
                count = 1;
            } else {
                curr = curr.next;
                count++;
            }

        }

        if(start != null) {
            listNode.add(start);
        }

        return listNode;
    }

    static Node reverseKGroup(Node head, int k) {
        if(k == 1 || head.next == null) return head;

        Node dummyHead = new Node(0);
        Node tail = dummyHead;

        ArrayList<Node> listOfNode = breakListInKGroup(head, k);
        
        for(Node temp : listOfNode) {
            while(temp != null) {
                tail.next = temp;
                tail = tail.next;
                temp = temp.next;
            }
        }

        return dummyHead.next;
    }






    static Node removeDuplicates(Node head){
        // Code Here.
        Node curr = head;
        while(curr.next != null) {
            
            Node nextNode = curr.next;
            while(nextNode != null && curr.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            
            curr.next = nextNode;
            curr = curr.next;
        }
        
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
            System.out.print(head.val + " ");
            // if(head.next != null) System.out.print("-> ");
            head = head.next;
        }
        System.out.println();
    }

}
