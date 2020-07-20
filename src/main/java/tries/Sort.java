package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sort {

    private static void sortArrayUtil(TrieNode root, String word, List<String> result) {

        if (root == null) {
            return;
        }

        if (root.isEndWord) {
            result.add(word);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                char c = (char) ('a' + i);
                sortArrayUtil(root.children[i], word + c, result);
            }
        }
    }

    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<String>();
        Trie trie = new Trie();

        for (String word : arr) {
            trie.insert(word);
        }

        sortArrayUtil(trie.root, "", result);
        return result;
    }

    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
            "by", "bye", "their", "abc"};

        System.out.println("Keys: " + Arrays.toString(keys));

        ArrayList<String> list = sortArray(keys);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
