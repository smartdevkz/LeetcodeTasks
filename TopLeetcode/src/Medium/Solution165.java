package Medium;

//https://leetcode.com/problems/compare-version-numbers/
public class Solution165 {

    public int compareVersion(String version1, String version2) {

        int i = 0, j = 0;
        int a = 0, b = 0;

        while (i < version1.length() || j < version2.length()) {

            if (i < version1.length() && version1.charAt(i) != '.') {
                a = a * 10 + Character.getNumericValue(version1.charAt(i));
                i++;
            }

            if (j < version2.length() && version2.charAt(j) != '.') {
                b = b * 10 + Character.getNumericValue(version2.charAt(j));
                j++;
            }

            if (i < version1.length() && j < version2.length() && version1.charAt(i) == '.' && version2.charAt(j) == '.') {
                if (a != b) {
                    return a > b ? 1 : -1;
                }

                i++;
                j++;
                a = 0;
                b = 0;
            }
        }
        if (a == b) return 0;
        return a > b ? 1 : -1;
    }

    public static void main(String[] args) {
        var app = new Solution165();
        var res = app.compareVersion("1.01.02", "1.1.1.2");
        System.out.println(res);
    }
}
