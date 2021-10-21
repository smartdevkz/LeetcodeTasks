package Easy;

//1662. Check If Two String Arrays are Equivalent
public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (var item : word1) {
            builder1.append(item);
        }
        for (var item : word2) {
            builder2.append(item);
        }
        return builder1.toString().equals(builder2.toString());
    }
}
