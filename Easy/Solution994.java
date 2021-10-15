package Easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import utils.Utils;

//994. Rotting Oranges
public class Solution994 {
    public static void main(String[] args) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();
        int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        var app = new Solution994();
        var res = app.orangesRotting(grid);
        System.out.println(res);
        Utils.printArray(grid);
    }

    Queue<Pair> pairs;

    public int orangesRotting(int[][] grid) {
        pairs = new LinkedList<>();

        // get rotten fruits
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    pairs.add(new Pair(i, j));
                }
            }
        }

        boolean hasFresh = true;

        int days = 0;
        while (hasFresh) {
            int count = pairs.size();
            hasFresh = false;
            boolean daysIncremented = false;
            for (int k = 0; k < count; k++) {
                var p = pairs.poll();
                if (hasFreshNeighbours(p.i, p.j, grid)) {
                    daysIncremented = true;
                    hasFresh = hasFresh || rot(p.i, p.j, grid);
                }
            }
            if (daysIncremented)
                days++;
        }
        return hasFresh(grid) ? -1 : days;
    }

    boolean hasFresh(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasFreshNeighbours(int i, int j, int[][] grid) {
        return isFresh(i - 1, j, grid) || isFresh(i + 1, j, grid) || isFresh(i, j - 1, grid) || isFresh(i, j + 1, grid);
    }

    boolean isFresh(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length)
            return false;
        if (j < 0 || j >= grid[i].length)
            return false;
        return grid[i][j] == 1;
    }

    boolean mark(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length)
            return false;
        if (j < 0 || j >= grid[i].length)
            return false;
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            pairs.add(new Pair(i, j));
            return hasFreshNeighbours(i, j, grid);
        }
        return false;
    }

    boolean rot(int i, int j, int[][] grid) {
        return mark(i - 1, j, grid) || mark(i + 1, j, grid) || mark(i, j - 1, grid) || mark(i, j + 1, grid);
    }

}
