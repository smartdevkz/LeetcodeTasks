package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/
public class Solution1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode trie = new TrieNode();
        for (var p : products) {
            trie.insert(p);
        }

        List<List<String>> res = new ArrayList<>();

        String prefix = new String();
        for (Character c : searchWord.toCharArray()) {
            prefix += c;
            res.add(trie.find(prefix));
        }

        return res;
    }

    public class TrieNode {

        private final int ALPHABET_SIZE = 26;
        private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }

        private List<String> resultBuffer;

        public void insert(String key) {

            TrieNode node = this;

            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }

            node.isEndOfWord = true;

        }

        public List<String> find(String prefix) {
            resultBuffer = new ArrayList<>();
            var node = this;
            for (var c : prefix.toCharArray()) {
                var idx = c - 'a';
                if (node.children[idx] == null) {
                    return List.of();
                }
                node = node.children[idx];
            }

            dfs(node, prefix);

            return resultBuffer;
        }


        public void dfs(TrieNode node, String prefix) {
            if (resultBuffer.size() == 3) return;
            if (node.isEndOfWord) {
                resultBuffer.add(prefix);
            }
            for (var c = 'a'; c <= 'z'; c++) {
                if (node.children[c - 'a'] != null) {
                    dfs(node.children[c - 'a'], prefix + c);
                }
            }
        }

    }

    public void run() {
        TrieNode root = new TrieNode();
        root.insert("key");
        var stop = 1;
    }

    public static void main(String[] args) {
        var app = new Solution1268();
        app.run();
    }
}
