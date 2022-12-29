package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        ArrayList<List<Integer>> lst = new ArrayList<List<Integer>>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                lst.add(List.of(start, end));
                start = intervals[i][0];
                end = intervals[i][1];

            } else if (end <= intervals[i][1]) {
                end = intervals[i][1];
            }
        }

        lst.add(List.of(start, end));

        return lst.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public void sortArray(int[][] arr) {

    }

    public static void main(String[] args) {
        var app = new Solution56();
        var res = app.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        System.out.println(res);
    }
}
