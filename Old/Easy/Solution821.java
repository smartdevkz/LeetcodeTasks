package Easy;
//821. Shortest Distance to a Character

import java.util.LinkedList;
import java.util.Queue;

import utils.Utils;

public class Solution821 {
    public static void main(String[] args) {
        var app = new Solution821();
        var arr = app.shortestToChar("cizokxcijwbyspcfcqws", 'c');
        Utils.printArray(arr);
        // [0,1,2,3,2,1,0,1,2,3,4,3,2,1,0,1,0,1,2,3]
    }

    public int[] shortestToChar(String s, char c) {
        var qu = getQueue(s, c);
        int[] arr = new int[s.length()];
        Integer current = qu.poll();
        Integer next = qu.poll();
        for (int i = 0; i < s.length(); i++) {
            if (next != null && Math.abs(i - current) > Math.abs(i - next)) {
                current = next;
                next = qu.poll();
            }
            arr[i] = Math.abs(current - i);
        }
        return arr;
    }

    Queue<Integer> getQueue(String s, char c) {
        Queue<Integer> lst = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                lst.add(i);
            }
        }
        return lst;
    }

}

/**
 * 
 */