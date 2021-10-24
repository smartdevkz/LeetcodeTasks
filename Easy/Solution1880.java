package Easy;

import utils.Utils;

//1880. Check if Word Equals Summation of Two Words
public class Solution1880 {
    public static void main(String[] args) {
        var app = new Solution1880();
        Utils.print(app.isSumEqual("aaa", "a", "aaaa"));
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        var target = getNumeric(targetWord);
        for (int i = 0; i < firstWord.length(); i++) {
            int number = (int) Math.pow(10, firstWord.length() - i-1) * (firstWord.charAt(i) - 'a');
            target -= number;
            if (target < 0)
                return false;
        }
        for (int i = 0; i < secondWord.length(); i++) {
            int number = (int) Math.pow(10, secondWord.length() - i-1) * (secondWord.charAt(i) - 'a');
            target -= number;
        }
        return target == 0;
    }

    int getNumeric(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum = 10 * sum + (word.charAt(i) - 'a');
        }
        return sum;
    }
}
