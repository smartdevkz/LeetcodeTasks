package Easy.Math;

//1523. Count Odd Numbers in an Interval Range
public class Solution1523 {

    public int countOdds(int low, int high) {
        if (low % 2 == 1) {
            low--;
        }
        if (high % 2 == 0) {
            high--;
        }
        return (high - low + 1) / 2;
    }

}
