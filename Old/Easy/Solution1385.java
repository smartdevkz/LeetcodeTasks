package Easy;

//https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int k = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean isMatched = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    isMatched = false;
                    break;
                }
            }
            if (isMatched)
                k++;
        }
        return k;
    }
}

/**
 * 
 * 
 * [2,1,100,3] [-5,-2,10,-3,7] 6
 */