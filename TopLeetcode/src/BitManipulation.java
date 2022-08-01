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
    static void bin(long n)
    {
        long i;
        System.out.print("0");
        for (i = 1 << 30; i > 0; i = i / 2)
        {
            if((n & i) != 0)
            {
                System.out.print("1");
            }
            else
            {
                System.out.print("0");
            }
        }
    }


    public static void main(String args[]) {
        bin(30000);
    }


}
