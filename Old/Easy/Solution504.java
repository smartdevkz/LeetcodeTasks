package Easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/base-7/
public class Solution504 {
    public static void main(String[] args) {
        int num = 10000000;
        var app = new Solution504();
        var res = app.convertToBase7(num);
        System.out.println(res);
    }

    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        boolean isNegative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        var maxDegree = getMaxDegree(num);

        for (int j = maxDegree; j >= 0; j--) {
            int div = (int) Math.pow(7, j);
            sb.append(num / div);
            num = num % div;
        }

        if (isNegative)
            sb.insert(0, "-");
        return sb.toString();
    }

    int getMaxDegree(int num) {
        int i = 0;
        int current = 1;
        while (current <= num) {
            i++;
            current *= 7;
        }
        return --i;
    }
}
