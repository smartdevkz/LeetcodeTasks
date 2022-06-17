package Easy;

import utils.Utils;

//1694. Reformat Phone Number
public class Solution1694 {
    public static void main(String[] args) {
        var app = new Solution1694();
        Utils.print(app.reformatNumber("1234567812345678965432"));
    }

    public String reformatNumber(String number) {
        StringBuilder builder = new StringBuilder();

        for (var ch : number.toCharArray()) {
            if (Character.isDigit(ch))
                builder.append(ch);
        }

        int step = 0;
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) != '-') {
                step++;
            }
            if (step == 3 && i != builder.length()-1) {
                builder.insert(i + 1, '-');
                step = 0;
            }
        }

        if (builder.length() > 3 && builder.charAt(builder.length() - 2) == '-') {
            builder.deleteCharAt(builder.length() - 2);
            builder.insert(builder.length() - 2, '-');
        }

        return builder.toString();
    }
}
