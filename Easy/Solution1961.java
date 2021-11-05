package Easy;

//https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
public class Solution1961 {
    public static void main(String[] args) {
        var app = new Solution1961();
        app.isPrefixString("z", new String[] { "z" });
    }

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (builder.length() < s.length()) {
                builder.append(words[i]);
            } else {
                break;
            }
        }
        return builder.toString().equals(s);
    }
}
