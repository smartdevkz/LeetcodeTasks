package TwoPointer;

public class ImplementStrStrApp {
    public static void main(String[] args) {
        ImplementStrStrApp app = new ImplementStrStrApp();
        System.out.println(app.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if (haystack.length() < needle.length())return -1;
        if(haystack.equals(needle))return 0;

        int k = 0;
        int i = 0;
        while (i<(haystack.length()-needle.length()+k)) {
            if (haystack.charAt(i) == needle.charAt(k)) {
                if (k == (needle.length() - 1)) return i - k;
                k++;
                i++;
            } else {
                i = i-k+1;
                k = 0;
            }
        }
        return -1;
    }
}