package Easy;

//1221. Split a String in Balanced Strings
public class Solution1221 {
    public static void main(String[] args) {

    }

    public int balancedStringSplit(String s) {

        int n = 0;
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                n++;
            } else {
                n--;
            }
            if (n == 0)
                k++;
        }

        return k;
    }
}