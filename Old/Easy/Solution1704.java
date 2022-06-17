package Easy;

//1704. Determine if String Halves Are Alike
public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int k = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                ++k;
            }
            if (vowels.indexOf(s.charAt(s.length() / 2 + i)) >= 0) {
                --k;
            }
        }
        return k == 0;
    }
}
