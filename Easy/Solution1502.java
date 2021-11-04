package Easy;

import java.util.Arrays;

//1502. Can Make Arithmetic Progression From Sequence
public class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d)
                return false;
        }
        return true;
    }
}
