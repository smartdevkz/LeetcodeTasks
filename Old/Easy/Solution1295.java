package Easy;

//1295. Find Numbers with Even Number of Digits
public class Solution1295 {
    public int findNumbers(int[] nums) {
        int k = 0;
        for (var n : nums) {
            if (isEven(n))
                k++;
        }
        return k;
    }

    boolean isEven(int n) {
        boolean isEven = true;
        while (n > 0) {
            n = n / 10;
            isEven = !isEven;
        }
        return isEven;
    }
}