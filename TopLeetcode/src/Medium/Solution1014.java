package Medium;

public class Solution1014 {
    public static void main(String[] args) {

    }

    public int MaxScoreSightseeingPair(int[] values) {
        int sum = 0;
        int a = 0;

        for (int i = 0; i < values.length; i++) {
            sum = Math.max(sum, a + values[i]);
            a = Math.max(a, values[i]) - 1;
        }
        return sum;
    }
}
