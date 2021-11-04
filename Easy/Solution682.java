package Easy;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

//https://leetcode.com/problems/baseball-game/
public class Solution682 {
    public static void main(String[] args) {

        var app = new Solution682();
        Utils.print(app.calPoints(new String[] { "5", "2", "C", "D", "+" }));
    }

    public int calPoints(String[] ops) {
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < ops.length; i++) {
            int j = lst.size() - 1;
            if (ops[i].equals("C")) {
                lst.remove(j);
            } else if (ops[i].equals("D")) {
                int score = lst.get(j) * 2;
                lst.add(score);
            } else if (ops[i].equals("+")) {
                int score = lst.get(j) + lst.get(j - 1);
                lst.add(score);
            } else {
                int score = Integer.parseInt(ops[i]);
                lst.add(score);
            }
        }

        int sum = 0;
        for (var item : lst) {
            sum += item;
        }
        return sum;
    }
}
