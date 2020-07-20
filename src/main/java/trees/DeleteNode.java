package trees;

public class DeleteNode {

    static Node deleteKey(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = deleteKey(root.left, key);
        } else if (key > root.data) {
            root.right = deleteKey(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node min = findMin(root.right);
                root.data = min.data;
                root.right = deleteKey(root.right, root.data);
            }
        }

        return root;
    }

    static Node findMin(Node root) {
        Node min = root;
        while (min.left != null) {
            min = min.left;
        }

        return min;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.root = deleteKey(tree.root, 20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.root = deleteKey(tree.root, 30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.root = deleteKey(tree.root, 50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}