package Easy;

//1844. Replace All Digits with Characters
public class Solution1844 {
    public static void main(String[] args) {
        // System.out.println((char) ('a' + '1'));
        var app = new Solution1844();
        var res = app.replaceDigits("a1c1e1");
        System.out.println(res);
    }

    public String replaceDigits(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                builder.append((char) ((int) s.charAt(i - 1) + Character.getNumericValue(ch)));
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
