package Easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

import utils.Utils;

//2053. Kth Distinct String in an Array
public class Solution2053 {

    public static void main(String[] args) {
        var app = new Solution2053();
        var res = app.kthDistinct(new String[] { "d", "b", "c", "b", "c", "a" }, 2);
        Utils.print(res);
    }

    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hm = new LinkedHashMap<>();
        for (var item : arr) {
            hm.put(item, hm.getOrDefault(item, 0) + 1);
        }
        for (var key : hm.keySet()) {
            if (hm.get(key) == 1) {
                k--;
            }
            if (k == 0)
                return key;
        }
        return "";
    }
}
