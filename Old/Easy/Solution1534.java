package Easy;

//1534. Count Good Triplets
public class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (getDiff(arr[i], arr[j]) > a)
                    continue;
                for (int k = j + 1; k < arr.length; k++) {
                    if (getDiff(arr[j], arr[k]) > b)
                        continue;
                    if (getDiff(arr[i], arr[k]) > c)
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

    int getDiff(int a, int b) {
        return Math.abs(a - b);
    }
}
