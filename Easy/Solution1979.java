package Easy;

//1979. Find Greatest Common Divisor of Array
public class Solution1979 {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int n : nums) {
            if (min > n)
                min = n;
            if (max < n)
                max = n;
        }
        for (int i = min; i > 1; i--) {
            if (min % i == 0 && max % i == 0)
                return i;
        }
        return 1;
    }
}
