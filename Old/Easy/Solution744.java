package Easy;

//744. Find Smallest Letter Greater Than Target
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1])
            return letters[0];
        for (int i = 0; i < letters.length; i++) {
            if (target < letters[i]) {
                return letters[i];
            }
        }
        return ' ';
    }
}
