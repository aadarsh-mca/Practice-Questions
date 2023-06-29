package DSA;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class TreeTraversal {
    static TreeNode root;

    public static void main(String[] args) {
        TreeTraversal obj = new TreeTraversal();

        root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);

        inorder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);

    }

    static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);
    }

    static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + "  ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    static void postOrder(TreeNode root) {
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