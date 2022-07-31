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
