package Easy;

import utils.Utils;

//https://leetcode.com/problems/calculate-money-in-leetcode-bank/
public class Solution1716 {
    public static void main(String[] args) {
        var app = new Solution1716();
        Utils.print(app.totalMoney(10));
    }

    public int totalMoney(int n) {
        if (n == 1)
            return 1;
        int sum = 0;
        int prev = 0;
        int i = 0;
        while (n > 0) {
            n--;
            i++;
            sum += prev + i;
            if (i == 7) {
                prev++;
                i = 0;
            }
        }
        return sum;
    }

}
