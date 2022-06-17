package Easy;

import java.util.List;

//1773. Count Items Matching a Rule
public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int k = 0;
        for (var item : items) {
            if (isMatched(item, ruleKey, ruleValue))
                k++;
        }
        return k;
    }

    boolean isMatched(List<String> item, String key, String value) {
        switch (key) {
        case "type":
            return item.get(0).equals(value);
        case "color":
            return item.get(1).equals(value);
        case "name":
            return item.get(2).equals(value);
        default:
            return false;
        }
    }
}
