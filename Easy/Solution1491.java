package Easy;

import java.util.Arrays;

//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
public class Solution1491 {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int min = salary[0];
        int max = salary[salary.length - 1];
        int k = 0;
        int sum = 0;
        for (var item : salary) {
            if (item != min && item != max) {
                k++;
                sum += item;
            }
        }
        return (double) sum / k;
    }
}
