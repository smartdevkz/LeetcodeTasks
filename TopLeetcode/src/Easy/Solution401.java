package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/binary-watch/
public class Solution401 {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i <= turnedOn; i++) {
            var hours = getNumbers(i, new int[]{1, 2, 4, 8});
            var minutes = getNumbers(turnedOn - i, new int[]{1, 2, 4, 8, 16, 32});

            for (var h : hours) {
                if (h > 11) continue;
                for (int m : minutes) {
                    if (m > 59) continue;
                    result.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }

        return result;
    }

    List<Integer> getNumbers(int n, int[] items) {
        if (n == 0) return List.of(0);
        var res = new ArrayList<Integer>();
        solve(0, 0, n, items, res);
        return res;
    }

    void solve(int val, int idx, int n, int[] items, List<Integer> result) {
        for (int i = idx; i < items.length; i++) {
            int newVal = val + items[i];
            if (n == 1) {
                result.add(newVal);
            } else {
                solve(newVal, i + 1, n - 1, items, result);
            }
        }
    }

    void display(List<String> result) {
        for (var res : result) {
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        var app = new Solution401();
        var res = app.readBinaryWatch(2);
        app.display(res);
    }
}
