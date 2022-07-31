package Medium;

import java.util.*;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        var res = new ArrayList<Integer>();
        res.add(0);
        solve(res, n, 0);
        return res;
    }

    void solve(List<Integer> lst, int n, int k) {
        if (n == 0) return;
        int m = lst.size();
        for (int i = m; i >= 0; i--) {
            var val = lst.get(i) | (1 << k);
            lst.add(val);
        }
        solve(lst, --n, ++k);
    }

    public static void main(String[] args) {
        var app = new Solution89();
        var res = app.grayCode(2);


    }
}
