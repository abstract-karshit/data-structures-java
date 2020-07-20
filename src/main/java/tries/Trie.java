package tries;

import java.util.Arrays;

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int getIndex(char c) {
        return c - 'a';
    }

    public void insert(String key) {
        if (key == null || key.equals("")) {
            return;
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            int index = this.getIndex(key.charAt(i));
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }

            currentNode = currentNode.children[index];
        }

        currentNode.markAsLeaf();
    }

    public boolean search(String key) {
        if (key == null || key.equals("")) {
            return false;
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            int index = getIndex(key.charAt(i));
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }

        return currentNode.isEndWord;
    }

    public void delete(String key) {
        deleteUtil(root, key, 0);
    }

    private TrieNode deleteUtil(TrieNode node, String key, int level) {
        if (node == null) {
            return null;
        }

        if (level == key.length()) {
            node.unMarkAsLeaf();

            if (hasNoChildren(node)) {
                node = null;
            }

            return node;
        }

        int index = key.charAt(level) - 'a';
        node.children[index] = deleteUtil(node.children[index], key, level + 1);

        if (hasNoChildren(node) && !node.isEndWord) {
            node = null;
        }

        return node;
    }

    private boolean hasNoChildren(TrieNode node) {
        for (int i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
            "by", "bye", "their", "abc"};
        String[] output = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: " + Arrays.toString(keys));

        // Construct trie
        for (String key : keys) {
            t.insert(key);
        }

        // Search for different keys
        // Search for different keys and delete if found
        if (t.search("the")) {
            System.out.println("the --- " + output[1]);
            t.delete("the");
            System.out.println("Deleted key \"the\"");
        } else {
            System.out.println("the --- " + output[0]);
        }

        if (t.search("these")) {
            System.out.println("these --- " + output[1]);
            t.delete("these");
            System.out.println("Deleted key \"these\"");
        } else {
            System.out.println("these --- " + output[0]);
        }

        if (t.search("abc")) {
            System.out.println("abc --- " + output[1]);
            t.delete("abc");
            System.out.println("Deleted key \"abc\"");
        } else {
            System.out.println("abc --- " + output[0]);
        }

        // check if the string has deleted correctly or still present
        if (t.search("abc")) {
            System.out.println("abc --- " + output[1]);
        } else {
            System.out.println("abc --- " + output[0]);
        }
    }
}
