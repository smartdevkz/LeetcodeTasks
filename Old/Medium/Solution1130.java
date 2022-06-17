package Medium;

//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
public class Solution1130 {
    public static void main(String[] args) {
        Solution1130 app = new Solution1130();
        System.out.println(app.mctFromLeafValues(new int[] { 6, 2, 4 }));
    }

    public int mctFromLeafValues(int[] arr) {
        return getSum(arr);
    }

    private int getSum(int[] arr) {
        if (arr.length < 2)
            return 0;
        int p = getProduct(arr);
        if (arr.length == 2)
            return p;
        if (p == 0)
            return 0;
        int i = getIndex(arr);
        int[] arr1 = getSubArray(arr, 0, i + 1);
        int[] arr2 = getSubArray(arr, i + 1, arr.length);
        return p + getProduct(arr1) + getProduct(arr2);
    }

    private int getProduct(int[] arr) {
        int p = 1;
        for (int i = 0; i < arr.length; i++) {
            p *= arr[i];
        }
        return p;
    }

    private int[] getSubArray(int[] arr, int startIndex, int endIndex) {
        int[] res = new int[endIndex - startIndex];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[startIndex + i];
        }
        return res;
    }

    private int getIndex(int[] arr) {
        int min = getProduct(arr);
        int minIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            var arr1 = getSubArray(arr, 0, i);
            var arr2 = getSubArray(arr, i, arr.length);
            int p1 = getProduct(arr1);
            int p2 = getProduct(arr2);
            if (min > p1 + p2) {
                min = p1 + p2;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int getSum2(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }
}