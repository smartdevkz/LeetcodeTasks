package Easy;

//1732. Find the Highest Altitude
public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int h = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            h += gain[i];
            if (max < h)
                max = h;
        }
        return max;
    }
}
