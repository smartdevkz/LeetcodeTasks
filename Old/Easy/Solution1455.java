package Easy;

//1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
public class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        var arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= searchWord.length()) {
                boolean isPrefix = true;
                for (int j = 0; j < searchWord.length(); j++) {
                    if (searchWord.charAt(j) != arr[i].charAt(j)) {
                        isPrefix = false;
                        break;
                    }
                }
                if (isPrefix) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
