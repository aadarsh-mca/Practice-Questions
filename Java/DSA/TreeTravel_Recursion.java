package DSA;

class TreeTravel_Recursion_Node {
    String data;
    TreeTravel_Recursion_Node left;
    TreeTravel_Recursion_Node right;

    TreeTravel_Recursion_Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class TreeTravel_Recursion {
    static TreeTravel_Recursion_Node root;

    public static void main(String[] args) {
        TreeTravel_Recursion obj = new TreeTravel_Recursion();

        root = new TreeTravel_Recursion_Node("-");
        root.left = new TreeTravel_Recursion_Node("+");
        root.right = new TreeTravel_Recursion_Node("*");
        root.right.left = new TreeTravel_Recursion_Node("G");
        root.right.right = new TreeTravel_Recursion_Node("H");
        root.left.left = new TreeTravel_Recursion_Node("+");
        root.left.right = new TreeTravel_Recursion_Node("F");
        root.left.left.left = new TreeTravel_Recursion_Node("/");
        root.left.left.right = new TreeTravel_Recursion_Node("*");
        root.left.left.right.left = new TreeTravel_Recursion_Node("D");
        root.left.left.right.right = new TreeTravel_Recursion_Node("E");
        root.left.left.left.left = new TreeTravel_Recursion_Node("*");
        root.left.left.left.right = new TreeTravel_Recursion_Node("C");
        root.left.left.left.left.left = new TreeTravel_Recursion_Node("A");
        root.left.left.left.left.right = new TreeTravel_Recursion_Node("B");
        // root = new TreeTraversal_Recursion_Node(10);
        // root.left = new TreeTraversal_Recursion_Node(20);
        // root.right = new TreeTraversal_Recursion_Node(30);
        // root.left.left = new TreeTraversal_Recursion_Node(40);
        // root.left.right = new TreeTraversal_Recursion_Node(50);
        // root.right.left = new TreeTraversal_Recursion_Node(60);
        // root.right.right = new TreeTraversal_Recursion_Node(70);

        inorder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);

        // System.out.println(depthOfTree(root.left, root, root.right, 0));
        // System.out.println(depthOfTree(root, 0));
    }

    static int depthOfTree(TreeTravel_Recursion_Node root, int leftDepth) {
        // if(root.left == null) {
        //     return leftDepth;
        // }
        // leftDepth++;
        // depthOfTree(root.left, leftDepth);
        
        int depth = 0;
        while(root.left != null) {
            depth++;
            root = root.left;
        }
        
        return depth;
    }

    static void inorder(TreeTravel_Recursion_Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);
    }

    static void preOrder(TreeTravel_Recursion_Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + "  ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    static void postOrder(TreeTravel_Recursion_Node root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "  ");
    }

    
}




// static void inorder(TreeNode left, TreeNode root, TreeNode right) {
    //     if(left == null || right == null) {
    //         return;
    //     }

    //     inorder(root.left, root.left, root.right);
    //     System.out.print(root.data + " ");
    //     inorder(root.left, root.right, root.right);

    // }