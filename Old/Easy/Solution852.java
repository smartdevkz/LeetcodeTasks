package Easy;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class Solution852 {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[i + 1])
                return i;
        }
        return -1;
    }
}
