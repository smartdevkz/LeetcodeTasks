package Easy;

//1309. Decrypt String from Alphabet to Integer Mapping
public class Solution1309 {

    public static void main(String[] args) {
        var app = new Solution1309();
        System.out.println(app.freqAlphabets("10#11#12"));
    }

    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            Integer number = null;
            if (s.charAt(i) == '#') {
                int a = Character.getNumericValue(s.charAt(i - 2));
                int b = Character.getNumericValue(s.charAt(i - 1));
                number = a * 10 + b;
                i = i - 3;
            } else {
                number = Character.getNumericValue(s.charAt(i));
                i--;
            }
            Character letter = number > 9 ? (char) ('j' + (number - 10)) : (char) ('a' + (number - 1));
            builder.insert(0, letter);
        }
        return builder.toString();
    }
}
