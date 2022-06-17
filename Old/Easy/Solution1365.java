package Easy;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.stream.IntStream;

import utils.Utils;

public class Solution1365 {

    public static void main(String[] args) {
        var app = new Solution1365();
        var res = app.smallerNumbersThanCurrent(new int[] { 0, 1 });
        Utils.display(res);
    }

    Hashtable<Integer, Integer> ht;

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = IntStream.of(nums).sorted().toArray();

        ht = new Hashtable<>();
        ht.put(sorted[0], 0);

        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == sorted[i - 1]) {
                continue;
            } else {
                ht.put(sorted[i], i);
            }
        }
        return IntStream.of(nums).map(a -> ht.get(a)).toArray();
    }

}
