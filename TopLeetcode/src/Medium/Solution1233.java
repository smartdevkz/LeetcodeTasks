package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
public class Solution1233 {

    public List<String> removeSubfolders(String[] folder) {

        var root = new TrieNode();

        for (var path : folder) {
            root.insert(path);
        }

        List<String> result = new ArrayList<>();

        dfs(result, root, "");

        return result;
    }

    private void dfs(List<String> result, TrieNode node, String path) {

        if (node.isEndOfPath) {
            result.add(path);
            return;
        }

        for (var child : node.children.entrySet()) {
            dfs(result, child.getValue(), path + "/" + child.getKey());
        }
    }

    class TrieNode {
        private Map<String, TrieNode> children;
        private boolean isEndOfPath;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfPath = false;
        }

        public void insert(String path) {

            var names = path.split("/");

            var node = this;
            for (String name : names) {
                if (name == "") continue;
                if (!node.children.containsKey(name)) {
                    node.children.put(name, new TrieNode());
                }
                node = node.children.get(name);
            }

            node.isEndOfPath = true;
        }

    }

    public void display(List<String> items) {
        for (var i : items) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        var app = new Solution1233();
        var res = app.removeSubfolders(new String[]{"/a", "/b", "/a/b", "/c/b"});
        app.display(res);
    }

}
