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

    //binary representation of a number
    static String bin(int n) {
        String res = Integer.toBinaryString(n);
        int k = res.length();
        for (int i = 0; i < 32 - k; i++) {
            res = "0" + res;
        }
        return res;
    }


    public static void main(String args[]) {
        //System.out.println(bin(-1));
        System.out.println(bin(30));
        System.out.println(bin(~30));
        System.out.println(bin(-30));
        System.out.println(~30 & 30);
        System.out.println(Integer.toBinaryString(1 << 32));
        int num = 5;
       

    }


}
