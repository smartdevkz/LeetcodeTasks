public class Solution {
    public static void main(String[] args) {
        int x = 32;
        var g = 15 & (1 << 10);
        for (int i = 31; i >= 0; i--) {
            if ((x & (1 << i)) == 0) System.out.print("0");
            else System.out.print("1");
            //System.out.print("-");
            //System.out.println(x & (1 << i));
        }
    }
}
