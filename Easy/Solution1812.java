package Easy;

public class Solution1812 {
    public boolean squareIsWhite(String coordinates) {
        int a = coordinates.charAt(0) - 'a' + 1;
        int b = Character.getNumericValue(coordinates.charAt(1));
        return a % 2 == 1 ? b % 2 == 0 : b % 2 == 1;
    }
}
