package Medium;

//https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
public class Solution1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int res = 0;

        int start = 0;

        int target = k * threshold;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                if (sum >= target) res++;
                sum -= arr[start];
                start++;
            }
        }

        return res;

    }

}
