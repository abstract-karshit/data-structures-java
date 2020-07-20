package tries;

class TrieNode {

    TrieNode[] children;
    boolean isEndWord;
    static final int ALPHABET_SIZE = 26;

    public TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
        isEndWord = false;
    }

    public void markAsLeaf() {
        this.isEndWord = true;
    }

    public void unMarkAsLeaf() {
        this.isEndWord = false;
    }
}
