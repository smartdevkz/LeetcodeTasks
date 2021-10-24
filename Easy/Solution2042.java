package Easy;

import utils.Utils;

//2042. Check if Numbers Are Ascending in a Sentence
public class Solution2042 {
    public static void main(String[] args) {
        var app = new Solution2042();
        Utils.print(app.areNumbersAscending("hello world 5 x 5"));
    }

    public boolean areNumbersAscending(String s) {
        var prev = -1;
        for (var item : s.split(" ")) {
            if (!Character.isDigit(item.charAt(0)))
                continue;
            int number = Integer.parseInt(item);
            if (prev >= number) {
                return false;
            } else {
                prev = number;
            }
        }
        return true;
    }
}
