package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import utils.Utils;

//1408. String Matching in an Array
public class Solution1408 {

    public static void main(String[] args) {
        var app = new Solution1408();
        var res = app.stringMatching(new String[] { "mass", "as", "hero", "superhero" });
        Utils.print(res);
    }

    public List<String> stringMatching(String[] words) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j)
                    continue;
                if (words[i].length() > words[j].length())
                    continue;
                if (words[j].indexOf(words[i]) >= 0)
                    hs.add(words[i]);
            }
        }
        return hs.stream().collect(Collectors.toList());
    }
}
