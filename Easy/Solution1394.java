package Easy;

import java.util.Arrays;

//https://leetcode.com/problems/find-lucky-integer-in-an-array/
public class Solution1394 {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int frequency = arr[arr.length - 1];
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (frequency == arr[i]) {
                sum++;
            } else {
                if (frequency == sum)
                    return frequency;
                frequency = arr[i];
                sum = 1;
            }
        }
        return frequency == sum ? frequency : -1;
    }
}
