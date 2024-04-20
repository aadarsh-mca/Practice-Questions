public class SortSinglyLL {
    
    public static void main(String[] args) {
        int[] arr = {6,4,2,5,1,3};
        Node head = createLL(arr);
        System.out.println("Before : ");
        printLL(head);

        System.out.println("After : ");
        printLL(sort_byMergerSort(head));
    }

    /**
     * Sorting Linked List using Merge Sort intution.
     * 
     * <p>Time Complexity : {@code O(n log n)}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param head
     * @return {@code head} of sorted LL
     */
    static Node sort_byMergerSort(Node head) {
        if(head.next == null) return head;

        /**
         * Finding the middle Node
         */
        Node midNode = findMidNode(head);

        /**
         * [6, 4, 2, 5, 1, 3]
         *        ^ mid node
         * 
         * Getting the head of 'left' hypothetical LL,
         * and the head of 'right' hypothetical LL.
         * 
         * leftHead = head (6, 4, 2, 5, 1, 3, null)
         * rightHead = midNode.next (5, 1, 3, null)
         * 
         * ** Also don't forget to set null on the end of leftHead,
         * i.e. leftHead = head (6, 4, 2, null)
         */
        Node leftHead = head;
        Node rightHead = midNode.next;
        midNode.next = null;

        /**
         * Sorting the leftHead and getting the head of sorted left,
         * also sorting the rightHead.
         */
        leftHead = sort_byMergerSort(leftHead);
        rightHead = sort_byMergerSort(rightHead);

        /**
         * Merging both the sorted LL,
         * i.e. leftHead & rightHead.
         */
        return mergeLL(leftHead, rightHead);
    }

    static Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
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








    /**
     * Driver Code
     */
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
