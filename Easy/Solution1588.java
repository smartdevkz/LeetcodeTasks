package Easy;

//https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
public class Solution1588 {
    public static void main(String[] args) {
        var app = new Solution1588();
        app.sumOddLengthSubarrays(new int[] { 1, 4, 2, 5, 3 });
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int k = 1;
        while (k <= arr.length) {
            System.out.println("k=" + k);
            for (int i = 0; i < arr.length; i++) {
                int s = 0;
                System.out.println("i=" + i);
                for (int j = i; j < i + k && i + k <= arr.length; j++) {
                    s += arr[j];
                    System.out.print(arr[j] + " ");
                }
                res += s;
                System.out.println("");
            }
            k += 2;
        }
        System.out.println("res=" + res);
        return res;
    }
}
