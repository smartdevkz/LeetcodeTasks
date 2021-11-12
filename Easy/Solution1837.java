package Easy;

//https://leetcode.com/problems/sum-of-digits-in-base-k/
public class Solution1837 {
    public int sumBase(int n, int k) {
        int a = 1;
        while (a <= n) {
            a = a * k;
        }
        a = a / k;
        int s = 0;
        while (n != 0) {
            s += n / a;
            n = n % a;
            a = a / k;
        }
        return s;
    }
}
