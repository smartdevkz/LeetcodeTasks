package Easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/build-an-array-with-stack-operations/
public class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n && j < target.length; i++) {
            res.add("Push");
            if (target[j] == i) {
                j++;
            } else {
                res.add("Pop");
            }
        }
        return res;
    }
}
