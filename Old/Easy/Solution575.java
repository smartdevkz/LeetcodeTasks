package Easy;

import java.util.HashSet;

//https://leetcode.com/problems/distribute-candies/
public class Solution575 {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length / 2;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            hs.add(candyType[i]);
            if (hs.size() > n)
                return n;
        }
        return hs.size();
    }
}
