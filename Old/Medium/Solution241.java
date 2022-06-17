package Medium;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class Solution241 {

    public static void main(String[] args) {
        var app = new Solution241();
        System.out.println(app.diffWaysToCompute("2-1-1"));
    }

    List<Character> operators = List.of('+', '-', '*');

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (operators.contains(expression.charAt(i))) {
                var part1 = diffWaysToCompute(expression.substring(0, i));
                var part2 = diffWaysToCompute(expression.substring(i + 1));
                for (var p1 : part1) {
                    for (var p2 : part2) {
                        int c = 0;
                        switch (expression.charAt(i)) {
                            case '+':
                                c = p1 + p2;
                            case '-':
                                c = p1 - p2;
                            case '*':
                                c = p1 * p2;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if (res.isEmpty())
            res.add(Integer.valueOf(expression));

        return res;
    }

}
