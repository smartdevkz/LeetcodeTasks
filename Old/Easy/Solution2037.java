package Easy;

import java.util.Arrays;

//2037. Minimum Number of Moves to Seat Everyone
public class Solution2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += Math.abs(students[i] - seats[i]);
        }
        return sum;
    }
}
