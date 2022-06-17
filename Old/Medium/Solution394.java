package Medium;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

//https://leetcode.com/problems/decode-string/
public class Solution394 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        var app = new Solution394();
        var res = app.decodeString(s);
        Utils.print(res);

    }

    public String decodeString(String s) {
        if (s.isEmpty())
            return "";
        List<Integer> numbers = new ArrayList<>();
        List<String> values = new ArrayList<>();

        int n = 0;
        int enters = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);

            if (ch == ']') {
                enters--;
            }

            if (enters == 0) {
                if (Character.isDigit(ch)) {
                    if (sb.length() > 0) {
                        values.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    n = n * 10 + Character.getNumericValue(ch);
                }
            }

            if (enters > 0) {
                sb.append(ch);
                if (n > 0) {
                    numbers.add(n);
                    n = 0;
                }
            }
            if (ch == '[') {
                enters++;
            }
        }

        if (numbers.size() == 0)
            return s;

        if (sb.length() > 0) {
            values.add(sb.toString());
            sb = new StringBuilder();
        }

        for (int i = 0; i < numbers.size(); i++) {
            String val = values.get(i);
            n = numbers.get(i);
            var decoded = decodeString(val);
            for (int j = 0; j < n; j++) {
                sb.append(decoded);
            }
        }
        return sb.toString();
    }

    public String decodeString2(String s) {
        if (s.isEmpty())
            return "";
        List<Integer> numbers = new ArrayList<>();
        List<String> values = new ArrayList<>();

        int n = 0;
        int enters = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);

            if (ch == ']') {
                enters--;
            }

            if (enters == 0) {
                if (Character.isDigit(ch)) {
                    if (sb.length() > 0) {
                        values.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    n = n * 10 + Character.getNumericValue(ch);
                }
            }

            if (enters > 0) {
                sb.append(ch);
                if (n > 0) {
                    numbers.add(n);
                    n = 0;
                }
            }
            if (ch == '[') {
                enters++;
            }
        }

        if (numbers.size() == 0)
            return s;

        if (sb.length() > 0) {
            values.add(sb.toString());
            sb = new StringBuilder();
        }

        for (int i = 0; i < numbers.size(); i++) {
            String val = values.get(i);
            n = numbers.get(i);
            var decoded = decodeString(val);
            for (int j = 0; j < n; j++) {
                sb.append(decoded);
            }
        }
        return sb.toString();
    }

    int index = 0;

    String decodeString3(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else {
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                index++;
                String decodedString = decodeString(s);
                index++;
                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return new String(result);
    }
}