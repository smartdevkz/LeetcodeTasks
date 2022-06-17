package Easy;

//1822. Sign of the Product of an Array
public class Solution1822 {
    public int arraySign(int[] nums) {
        int p = 1;
        for (int item : nums) {
            if (item == 0)
                return 0;
            p *= item > 0 ? 1 : -1;
        }
        return p;
    }
}
