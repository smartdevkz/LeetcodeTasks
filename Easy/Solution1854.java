package Easy;

import utils.Utils;

//https://leetcode.com/problems/maximum-population-year/
public class Solution1854 {
    public static void main(String[] args) {
        // [[1950,1961],[1960,1971],[1970,1981]]
        var app = new Solution1854();
        var logs = new int[][] { { 1950, 1961 }, { 1960, 1971 }, { 1970, 1981 } };
        Utils.print(app.maximumPopulation(logs));
    }

    public int maximumPopulation(int[][] logs) {
        int max = 0;
        int maxYear = logs[0][0];
        for (int i = 0; i < logs.length; i++) {
            int startYear = logs[i][0];
            int count = 0;
            for (int j = 0; j < logs.length; j++) {
                if (j == i)
                    continue;
                int currentStartYear = logs[j][0];
                int currentEndYear = logs[j][1];
                if ((startYear >= currentStartYear && startYear < currentEndYear)) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                maxYear = startYear;
            } else if (max == count) {
                if (maxYear > startYear)
                    maxYear = startYear;
            }
        }
        return maxYear;
    }
}
