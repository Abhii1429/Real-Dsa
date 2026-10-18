package assignments;


public class bst_00{

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // 1. Insert a value
    Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root; // Ignore duplicates
    }

    // 2. Search for a value
    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // 3. Inorder traversal: Left, Root, Right
    void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 4. Preorder traversal: Root, Left, Right
    void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 5. Postorder traversal: Left, Right, Root
    void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Find the minimum-valued node
    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // 6. Delete a value
    Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    public static void main(String[] args) {
        bst_00 tree = new bst_00();

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            tree.root = tree.insert(tree.root, value);
        }

        System.out.print("Inorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);

        System.out.println("\nSearch 40: " +
                tree.search(tree.root, 40));

        tree.root = tree.delete(tree.root, 30);

        System.out.print("After deleting 30: ");
        tree.inorder(tree.root);
    }
}
