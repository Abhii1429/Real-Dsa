public class heightOfBST_03 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    
    static Node insert(Node root, int data) {

        // If tree is empty, create a new node
        if (root == null) {
            return new Node(data);
        }

        
        if (data < root.data) {
            root.left = insert(root.left, data);
        }

        
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    //  height of BST
    static int height(Node root) {

        // Base case
        if (root == null) {
            return -1;
        }

       
        int leftHeight = height(root.left);

        
        int rightHeight = height(root.right);

        
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Node root = null;

        // Create BST
        root = insert(root, 10);
        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 2);
        root = insert(root, 7);

        System.out.println("Height of BST: " + height(root));
    }
}

