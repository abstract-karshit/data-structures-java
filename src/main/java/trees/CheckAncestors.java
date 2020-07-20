package trees;

class CheckAncestors {
    public static String findAncestors(Node root, int k) {
        StringBuilder sb = new StringBuilder();
        findAncestorsUtil(root, k, sb);
        return sb.toString();
    }

    private static void findAncestorsUtil(Node root, int k, StringBuilder sb) {
        if (root == null || root.data == k) {
            return;
        }

        sb.append(root.data).append(" - ");
        if (k < root.data) {
            findAncestorsUtil(root.left, k, sb);
        } else {
            findAncestorsUtil(root.right, k, sb);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.insert(6);
        tree.insert(4);
        tree.insert(9);
        tree.insert(2);
        tree.insert(5);
        tree.insert(8);
        tree.insert(8);
        tree.insert(12);
        tree.insert(10);
        tree.insert(14);

        int key = 10;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.root, key));

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.root, key));
    }
}
