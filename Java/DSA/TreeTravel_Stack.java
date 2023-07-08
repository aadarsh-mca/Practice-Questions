package DSA;

import java.util.Stack;

class TreeTravel_Stack_Node {
    int data;
    TreeTravel_Stack_Node left;
    TreeTravel_Stack_Node right;

    TreeTravel_Stack_Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class TreeTravel_Stack {
    static TreeTravel_Stack_Node root;
    static Stack<TreeTravel_Stack_Node> stack = new Stack<>();
    
    public static void main(String[] args) {

        root = new TreeTravel_Stack_Node(1);
        root.left = new TreeTravel_Stack_Node(2);
        root.right = new TreeTravel_Stack_Node(3);
        root.left.left = new TreeTravel_Stack_Node(4);
        root.left.right = new TreeTravel_Stack_Node(5);

        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        
        System.out.println();
        inOrder_Stack();
        System.out.println();
        preOrder_Stack();
        System.out.println();
        postOrder_Stack();
    }

    static void inOrder_Stack() {
        // L-Root-R
        if(root == null) {
            return;
        }
        
        TreeTravel_Stack_Node curr = root;
        while(curr != null || !stack.empty()) {
            while(curr != null) 
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    static void preOrder_Stack() {
        // Root-L-R
        TreeTravel_Stack_Node curr = root;
        while(curr != null || !stack.empty()) {
            while(curr != null) 
            {
                stack.push(curr);
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.left;
            }
            if(curr.left != null) {
                System.out.print(curr.left.data + " ");
            }
            if(curr.right != null) {
                System.out.print(curr.right.data + " ");
            }
            curr = null;
        }
    }

    static void postOrder_Stack() {
        // L-R-Root
        TreeTravel_Stack_Node curr = root;
        while(curr != null || !stack.empty()) {
            while(curr != null) 
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr.right != null) {
                System.out.print(curr.right.data + " ");
            }
            System.out.print(curr.data + " ");
            curr = null;
        }
    }

    static void inOrder(TreeTravel_Stack_Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + "  ");
        inOrder(root.right);
    }

    static void preOrder(TreeTravel_Stack_Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + "  ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    static void postOrder(TreeTravel_Stack_Node root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "  ");
    }


}
