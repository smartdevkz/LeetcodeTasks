package Easy;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> qu = new LinkedList<>();
        for (var item : students) {
            qu.add(item);
        }

        int passed = 0;
        int k = 0;
        while (k < sandwiches.length && !qu.isEmpty()) {
            var current = qu.poll();
            if (sandwiches[k] == current) {
                k++;
                passed = 0;
            } else {
                passed++;
                qu.add(current);
                if (passed == qu.size())
                break;
            }
            
        }
        return qu.size();
    }
}
