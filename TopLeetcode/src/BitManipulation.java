import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;

public class BitManipulation {
    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    HashMap<Integer, LinkedList<Integer>> getHashMap(int n) {
        var hm = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 1; i < Math.pow(2, n) - 1; i++) {
            var key = countSetBits(i);
            if (!hm.containsKey(key)) {
                hm.put(key, new LinkedList<>());
            }
            hm.get(key).add(i);
        }
        return hm;
    }

    public static void main(String args[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i <= 31; i++) {
            int key = countSetBits(i);
            int count = hm.getOrDefault(key, 0);
            hm.put(key, count + 1);
            System.out.print(key);
            System.out.print(" ");
        }
    }


}
