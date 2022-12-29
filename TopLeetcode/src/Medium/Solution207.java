package Medium;

import java.util.*;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var hm = new HashMap<Integer, List<Integer>>();
        for (var pairs : prerequisites) {
            int n = pairs[1];
            int d = pairs[0];
            if (hm.containsKey(n)) {
                hm.get(n).add(d);
            } else {
                List<Integer> lst = new LinkedList<>();
                lst.add(d);
                hm.put(n, lst);
            }
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (hasCycle(i, visited, hm, checked)) {
                return false;
            }
        }
        return true;
    }

    boolean hasCycle(int n, boolean[] visited, HashMap<Integer, List<Integer>> hm, boolean[] checked) {
        if (checked[n]) return false;
        if (visited[n]) return true;
        if (!hm.containsKey(n)) return false;
        visited[n] = true;
        var destinations = hm.get(n);
        boolean ret = false;
        for (int d : destinations) {
            ret = hasCycle(d, visited, hm, checked);
            if (ret) break;
        }
        visited[n] = false;
        checked[n] = true;
        return ret;
    }

    public static void main(String[] args) {
        var app = new Solution207();
        var res = app.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(res);
    }
}
