package Easy;

//https://leetcode.com/problems/defuse-the-bomb/
public class Solution1652 {
    public static void main(String[] args) {
        var app = new Solution1652();
        app.decrypt(new int[] { 5, 7, 1, 4 }, 3);
    }

    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0)
            return res;

        int sign = k > 0 ? 1 : -1;
        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            for (int j = 1; j <= Math.abs(k); j++) {
                sum += getVal(i + j * sign, code);
            }
            res[i] = sum;
        }

        return res;
    }

    int getVal(int i, int[] code) {
        while (i >= code.length) {
            i -= code.length;
        }
        while (i < 0) {
            i += code.length;
        }
        return code[i];
    }
}
