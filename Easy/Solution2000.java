package Easy;

//2000. Reverse Prefix of Word
public class Solution2000 {
    public String reversePrefix(String word, char ch) {
        StringBuilder buidler = new StringBuilder();
        boolean isFound = false;
        for (int i = 0; i < word.length(); i++) {
            buidler.append(word.charAt(i));
            if (!isFound && word.charAt(i) == ch) {
                isFound = true;
                buidler.reverse();
            }
        }
        return buidler.toString();
    }
}
