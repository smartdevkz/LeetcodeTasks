package Medium;

import java.util.Stack;

public class Solution2375 {

    public String smallestNumber(String pattern) {
        Stack st = new Stack<Integer>();

        String result = "";

        for (int i = 9; i >= 1; i--) {
            st.push(i);
        }

        Character prev = pattern.charAt(0);
        int count = 1;
        for (int i = 1; i < pattern.length(); i++) {
            if (prev == pattern.charAt(i)) {
                count++;
            } else {

                if (prev == 'I') {

                    for (int j = 0; j < count; j++) {
                        result += st.pop();
                    }

                } else if (prev == 'D') {
                    var skipped = st.pop();
                    String temp = "";
                    for (int j = 0; j < count; j++) {
                        temp = st.pop() + temp;
                    }
                    result += temp;
                    st.push(skipped);
                }

                prev = pattern.charAt(i);
                count = 1;
            }
        }

        if (prev == 'I') {

            for (int j = 0; j < count; j++) {
                result += st.pop();
            }

        } else if (prev == 'D') {
            var skipped = st.pop();
            String temp = "";
            for (int j = 0; j < count; j++) {
                if (st.empty()) break;
                temp = st.pop() + temp;
            }
            result += temp;
            result += skipped;
        }

        return result;
    }

    public static void main(String[] args) {
        var app = new Solution2375();

        System.out.println(app.smallestNumber("IIIDIDDD"));
    }
}
