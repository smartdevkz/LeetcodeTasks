package Easy;

//https://leetcode.com/problems/add-binary/
public class Solution67 {
    public String addBinary(String a, String b) {
        int m = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int x = i < a.length() ? Character.getNumericValue(a.charAt(a.length() - 1 - i)) : 0;
            int y = i < b.length() ? Character.getNumericValue(b.charAt(b.length() - 1 - i)) : 0;
            int val = (x ^ y) ^ m;
            sb.insert(0, Integer.toString(val));
            m = m == 0 ? (x & y) : (x | y);
        }
        if (m != 0) sb.insert(0, Integer.toString(m));
        return sb.toString();
    }

    public static void main(String[] args) {
        var app = new Solution67();
        var res = app.addBinary("1010", "1011");
        System.out.println(res);
    }
    
    
}
