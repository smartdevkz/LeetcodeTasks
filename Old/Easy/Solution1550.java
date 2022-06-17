package Easy;

//https://leetcode.com/problems/three-consecutive-odds/
public class Solution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                k++;
                if (k == 3)
                    return true;
            } else {
                k = 0;
            }
        }
        return false;
    }
}
