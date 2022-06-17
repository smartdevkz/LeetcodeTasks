package Easy;

//1952. Three Divisors
public class Solution1952 {
    public boolean isThree(int n) {
        if (n < 4)
            return false;
        long a = Math.round(Math.sqrt(n));
        if (a * a == n) {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0)
                    return false;
            }
            return true;
        }
        return false;
    }

}
