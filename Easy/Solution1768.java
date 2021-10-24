package Easy;

//1768. Merge Strings Alternately
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
            i++;
        }
        if(i<word1.length()){
            builder.append(word1.substring(i));
        }
        if(i<word2.length()){
            builder.append(word2.substring(i));
        }
        return builder.toString();
    }
}
