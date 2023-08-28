package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/daily-temperatures/
public class Solution739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < temperatures.length; currDay++) {

            int currTemp = temperatures[currDay];

            if (!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                var prevDay = stack.pop();
                result[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return result;
    }

}
