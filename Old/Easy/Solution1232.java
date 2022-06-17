package Easy;

//https://leetcode.com/problems/check-if-it-is-a-straight-line/
public class Solution1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3)
            return true;
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if ((x1 - x2) * (y1 - y) != (y1 - y2) * (x1 - x)) {
                return false;
            }
        }
        return true;
    }

}
