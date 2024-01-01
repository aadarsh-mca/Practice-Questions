public class ReverseLL {
    
    public static void main(String[] args) {
        // to reverse linked list in place without using any extra space
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(head.val);
        ListNode curr = head.next;
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}


}
