public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int k = -1;
        boolean isCommonPrefix = true;
        while (isCommonPrefix) {
            k++;
            if (k < strs[0].length()) {
                char c = strs[0].charAt(k);
                for (int i = 1; i < strs.length; i++) {
                    if (k >= strs[i].length() || strs[i].charAt(k) != c)
                        isCommonPrefix = false;
                }
            }else{
                break;
            }
        }
        k--;
        return k < 0 ? "" : strs[0].substring(0, ++k);
    }

}