package Easy;

//https://leetcode.com/problems/valid-palindrome/
public class Solution125 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return i >= j;
    }

    public static void main(String[] args) {
        var app = new Solution125();
        System.out.println(app.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
