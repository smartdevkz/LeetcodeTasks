package Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//1431. Kids With the Greatest Number of Candies
public class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i])
                max = candies[i];
        }
        int fMax = max;
        return Arrays.stream(candies).mapToObj(i -> i + extraCandies >= fMax).map(Boolean::booleanValue)
                .collect(Collectors.toList());
    }
}
