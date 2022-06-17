package Easy;

//1299. Replace Elements with Greatest Element on Right Side
public class Solution1299 {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            max = Math.max(arr[i + 1], max);
            res[i] = max;
        }
        return res;
    }
}
