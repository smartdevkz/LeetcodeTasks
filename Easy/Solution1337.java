package Easy;

import java.util.HashSet;

//1337. The K Weakest Rows in a Matrix
public class Solution1337 {

    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };
        var app = new Solution1337();
        var res = app.kWeakestRows(mat, 3);
        app.printArray(res);
        // var c = app.getCount(new int[] { 1, 1, 0, 0, 0 });
        // System.out.println(c);
    }

    void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            arr[i] = getCount(mat[i]);
        }
        mat = null;
        printArray(arr);
        int[] res = new int[k];
        HashSet<Integer> excepted = new HashSet<>();
        for (int i = 0; i < res.length; i++) {
            res[i] = getMinIndex(arr, excepted);
            excepted.add(res[i]);
        }
        return res;
    }

    public int getCount(int[] arr) {
        int left = 0, pivot;
        int right = arr.length - 1;
        if (arr[right] == 1)
            return arr.length;
        if (arr[left] == 0)
            return 0;
        while ((right - left) > 1) {
            pivot = left + (right - left) / 2;
            if (arr[pivot] == 1) {
                left = pivot;
            } else {
                right = pivot;
            }
        }
        return left + 1;
    }

    int getMinIndex(int[] arr, HashSet<Integer> excepted) {
        int min = -1;
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (excepted.contains(i))
                continue;
            if (minIndex == -1) {
                minIndex = i;
                min = arr[i];
                continue;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
