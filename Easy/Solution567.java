package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.Utils;

//567. Permutation in String
public class Solution567 {

    public static void main(String[] args) {
        var app = new Solution567();
        Utils.print(app.checkInclusion("ab", "eidbaooo"));

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int k = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        List<Integer> lst = new ArrayList<>();

        int i = 0;
        int min = -1;
        int max = -1;
        while (i < s1.length()) {
            var ch = s1.charAt(i);
            int searchStart = hm.containsKey(ch) ? hm.get(ch) + 1 : 0;
            int j = s2.indexOf(ch, searchStart);
            if (j >= 0) {
                lst.add(j);
            } else {
                return false;
            }

        }

        return false;
    }

}
