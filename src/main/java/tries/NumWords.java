package tries;

import java.util.Arrays;

class NumWords {

    private static void totalWordsUtil(TrieNode root, Answer answer) {
        if (root.isEndWord) {
            answer.answer++;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                totalWordsUtil(root.children[i], answer);
            }
        }
    }

    public static int totalWords(TrieNode root) {
        if (root == null) {
            return 0;
        }

        Answer answer = new Answer();
        totalWordsUtil(root, answer);
        return answer.answer;
    }

    static class Answer {
        int answer;
    }


    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
            "by", "bye", "their", "abc"};

        System.out.println("Keys: " + Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();
        for (String key : keys) {
            t.insert(key);
        }

        System.out.println(totalWords(t.root));
    }
}
