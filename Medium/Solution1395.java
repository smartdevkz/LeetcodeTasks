package Medium;

//https://leetcode.com/problems/count-number-of-teams/
public class Solution1395 {
    public static void main(String[] args) {

    }

    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if ((rating[i] > rating[j] && rating[j] > rating[k])
                            || (rating[i] < rating[j] && rating[j] < rating[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
