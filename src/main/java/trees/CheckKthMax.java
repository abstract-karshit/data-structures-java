package trees;

class CheckKthMax {

    static class Count {
        int c = 0;
        int kthMax;
    }

    public static int findKthMax(Node root, int k) {
        Count count = new Count();
        findKthMaxUtil(root, k, count);
        return count.kthMax;
    }

    private static void findKthMaxUtil(Node root, int k, Count count) {
        if (root == null || count.c > k) {
            return;
        }
        findKthMaxUtil(root.right, k, count);
        count.c++;
        if (count.c == k) {
            count.kthMax = root.data;
            return;
        }

        findKthMaxUtil(root.left, k, count);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(6);
        tree.insert(4);
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);

        System.out.println("Kth Max: " + findKthMax(tree.root, 3));
    }
}
