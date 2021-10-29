package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1431. Kids With the Greatest Number of Candies
public class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i])
                max = candies[i];
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}
