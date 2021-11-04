package Easy;

//1450. Number of Students Doing Homework at a Given Time
public class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int k = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                k++;
        }
        return k;
    }
}
