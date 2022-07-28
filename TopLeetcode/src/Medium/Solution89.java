package Medium;

import java.util.*;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        var hm = getHashMap(n);
        var res = new LinkedList<Integer>();
        var keySet = new ArrayList<>(hm.keySet());
        Collections.sort(keySet, Collections.reverseOrder());
        for (int key : keySet) {
            res.add(hm.get(key).pop());
        }

        for (int key : keySet) {
            var lst = hm.get(key);
            if (lst.size() == 0) continue;
            var lst2 = hm.get(key - 1);
            for (int val : lst) {
                res.addFirst(val);
                if (lst2 != null)
                    res.addFirst(lst2.pop());
            }
        }
        res.addFirst(0);
        return res;
    }

    int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    HashMap<Integer, LinkedList<Integer>> getHashMap(int n) {
        var hm = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 1; i <= Math.pow(2, n) - 1; i++) {
            var key = countSetBits(i);
            if (!hm.containsKey(key)) {
                hm.put(key, new LinkedList<>());
            }
            hm.get(key).add(i);
        }
        return hm;
    }

    public static void main(String[] args) {
        var app = new Solution89();
        var res = app.grayCode(2);
    }
}
