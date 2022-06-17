package Easy;

//https://leetcode.com/problems/maximum-69-number/
public class Solution1323 {
    public int maximum69Number(int num) {
        String s = num + "";
        s = s.replaceFirst("6", "9");
        return Integer.parseInt(s);
    }
}