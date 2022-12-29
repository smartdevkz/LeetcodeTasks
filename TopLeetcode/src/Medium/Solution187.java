package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/repeated-dna-sequences/
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        var hs = new HashSet<String>();
        var res = new HashSet<String>();
        for (int i = 0; i < s.length() - 9; i++) {
            var key = s.substring(i, i + 10);
            if (hs.contains(key)) {
                res.add(key);
            } else {
                hs.add(key);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        var app = new Solution187();
        System.out.println(app.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
