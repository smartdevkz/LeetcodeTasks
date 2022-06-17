package TwoPointer;

public class ImplementStrStrApp {
    public static void main(String[] args) {
        ImplementStrStrApp app = new ImplementStrStrApp();
        System.out.println(app.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))break;
            }
        }
    }
}