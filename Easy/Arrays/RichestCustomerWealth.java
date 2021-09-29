package Easy.Arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        System.out.println("hello world!!!");
    }

    public int maximumWealth(int[][] accounts) throws Exception {
        if (accounts == null || accounts.length == 0)
            throw new Exception("Illegal input argument");
        int max = accounts[0][0];
        for (int i = 0; i < accounts.length; i++) {
            int current = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                current += accounts[i][j];
            }
            if (i == 0) {
                max = current;
            } else {
                if (current > max)
                    max = current;
            }
        }
        return max;
    }
}
