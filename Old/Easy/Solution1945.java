package Easy;

import utils.Utils;

//1945. Sum of Digits of String After Convert
public class Solution1945 {

    public static void main(String[] args) {
        var app = new Solution1945();
        Utils.print(app.getLucky("leetcode", 2));
    }

    public int getLucky(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (var ch : s.toCharArray()) {
            int digit = ch - 'a' + 1;
            builder.append(digit);
        }

        if (builder.length() == 0)
            return 0;

        int sum = 0;
        while (builder.length() > 0) {
            sum += Character.getNumericValue(builder.charAt(0));
            builder.delete(0, 1);
            if (builder.length() == 0) {
                k--;
                if (sum < 10 || k == 0)
                    break;
                builder.append(sum);
                sum = 0;
            }
        }
        return sum;
    }
}
