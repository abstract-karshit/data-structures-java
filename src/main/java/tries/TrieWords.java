package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieWords {

    //Recursive Function to generate all words
    public static void getWords(TrieNode root, List<String> result, String word) {
        if (root.isEndWord) {
            result.add(word);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                char c = (char) ('a' + i);
                getWords(root.children[i], result, word + c);
            }
        }
    }

    public static ArrayList<String> findWords(TrieNode root) {
        ArrayList<String> result = new ArrayList<>();
        getWords(root, result, "");
        return result;
    }

    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any",
            "by", "bye", "their", "abc"};
        Trie t = new Trie();

        System.out.println("Keys: " + Arrays.toString(keys));

        // Construct trie
        for (String key : keys) {
            t.insert(key);
        }

        ArrayList<String> list = findWords(t.root);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
