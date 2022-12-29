package Medium;

//https://leetcode.com/problems/bitwise-and-of-numbers-range/
public class Solution201 {

    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) return left;
        int k = 31;
        System.out.println(Integer.toBinaryString(left));
        System.out.println(Integer.toBinaryString(right));
        while (getBitAt(left, k) == getBitAt(right, k)) {
            k--;
        }
        for (int i = k; i >= 0; --i) {
            left = setZeroAt(left, i);
        }
        return left;
    }

    int setZeroAt(int n, int k) {
        return n & ~(1 << k);
    }

    int getBitAt(int n, int k) {
        System.out.print("val: ");
        System.out.println(n & (1 << k));
        return n & (1 << k);
    }

    public static void main(String[] args) {
        var app = new Solution201();

        System.out.println(app.rangeBitwiseAnd(5, 7));
    }
}
