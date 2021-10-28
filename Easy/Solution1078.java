package Easy;

import java.util.ArrayList;
import java.util.List;

//1078. Occurrences After Bigram
public class Solution1078 {
    public String[] findOcurrences(String text, String first, String second) {
        var arr = text.split(" ");
        if (arr.length < 3)
            return null;
        List<String> lst = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 2].equals(first) && arr[i - 1].equals(second)) {
                lst.add(arr[i]);
                i++;
            }
        }
        return lst.toArray(String[]::new);
    }
}
