package Easy;

//1374. Generate a String With Characters That Have Odd Counts
public class Solution1374 {
    public String generateTheString(int n) {
        StringBuilder builder = new StringBuilder();
        if (n % 2 == 1) {
            builder.append('c');
            n--;
        }
        for (int i = 0; i < n-1; i++) {
            builder.append('a');
        }
        return builder.toString();
    }
}
