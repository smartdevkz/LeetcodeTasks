package Easy;

//2011. Final Value of Variable After Performing Operations
public class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int a = 0;
        for (String op : operations) {
            boolean isIncrement = op.charAt(1) == '+';
            a = isIncrement ? ++a : --a;
        }
        return a;
    }
}
