package Easy;

//167. Two Sum II - Input array is sorted
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int hight = numbers.length - 1;
        while (low < hight) {
            int sum = numbers[low] + numbers[hight];
            if (sum == target) {
                return new int[] { low + 1, hight + 1 };
            } else if (sum < target) {
                low++;
            } else {
                hight--;
            }
        }
        return new int[] { -1, -1 };
    }
}
