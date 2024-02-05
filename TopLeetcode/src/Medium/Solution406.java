package Medium;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/queue-reconstruction-by-height/
public class Solution406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) {
                    return 1;
                } else if (a[0] < b[0]) {
                    return -1;
                } else {
                    if (a[1] > b[1]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        display(people);

        System.out.println(" ");

        var result = new int[people.length][people[0].length];

        Arrays.fill(result, new int[]{-1, -1});

        //display(result);


        for (int i = 0; i < people.length; i++) {

            int h = people[i][0];
            int count = people[i][1];

            for (int j = 0; j < result.length; j++) {

                if (result[j][0] >= 0) {
                    if (result[j][0] >= h) {
                        count--;
                    }
                } else {
                    if (count == 0) {
                        result[j] = new int[]{people[i][0], people[i][1]};
                        break;
                    } else {
                        count--;
                    }
                }

            }


        }

        display(result);

        return result;
    }

    private void display(int[][] people) {
        for (var r : people) {
            for (var c : r) {
                System.out.print(c + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        var people = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        var app = new Solution406();

        app.reconstructQueue(people);
    }


}
