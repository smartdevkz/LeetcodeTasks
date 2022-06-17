package Easy;

//1374. Generate a String With Characters That Have Odd Counts
public class Solution1374 {
    public String generateTheString(int n) {
        StringBuilder builder = new StringBuilder();
        if (n % 2 == 0) {
            builder.append('a');
            n--;
        }
        while (n > 0) {
            builder.append('b');
            n--;
        }
        return builder.toString();
    }
}
