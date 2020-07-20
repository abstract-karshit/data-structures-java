package trees;

class CheckKNodes {

    public static String findKNodes(Node root, int k) {
        StringBuilder sb = new StringBuilder();
        findKNodesUtil(root, k, 0, sb);

        return sb.toString();
    }

    private static void findKNodesUtil(Node root, int k, int level, StringBuilder sb) {

        if (root == null || level > k) {
            return;
        }

        if (level == k) {
            sb.append(root.data).append(" - ");
            return;
        }
        findKNodesUtil(root.left, k, level + 1, sb);
        findKNodesUtil(root.right, k, level + 1, sb);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(4);
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(12);

        System.out.println(findKNodes(tree.root, 2));
    }
}

