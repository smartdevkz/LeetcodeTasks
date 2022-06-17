package Medium;

//https://leetcode.com/problems/stone-game/
public class Solution877 {

    public static void main(String[] args) {
        var app = new Solution877();
        var res = app.stoneGame(new int[] { 8, 9, 7, 6, 7, 6 });
        System.out.println("res=" + res);
    }

    public boolean stoneGame(int[] piles) {
        int s1 = 0;
        int s2 = 0;
        int l = 0;
        int r = piles.length - 1;
        int step = 0;
        while (r - l > 1) {
            boolean isFirstPlayer = ++step % 2 == 1;
            int leftDiffMin = Math.min(piles[l] - piles[l + 1], piles[l] - piles[r]);
            int rightDiffMin = Math.min(piles[r] - piles[l], piles[r] - piles[r - 1]);
            if (leftDiffMin > rightDiffMin) {
                if (isFirstPlayer) {
                    System.out.println("first: " + piles[l]);
                    s1 += piles[l];
                } else {
                    System.out.println("second: " + piles[l]);
                    s2 += piles[l];
                }
                l++;
            } else if (rightDiffMin > leftDiffMin) {
                if (isFirstPlayer) {
                    System.out.println("first: " + piles[r]);
                    s1 += piles[r];
                } else {
                    System.out.println("second: " + piles[r]);
                    s2 += piles[r];
                }
                r--;
            } else {
                if (piles[l] < piles[r]) {
                    if (isFirstPlayer) {
                        System.out.println("first: " + piles[l]);
                        s1 += piles[l];
                    } else {
                        System.out.println("second: " + piles[l]);
                        s2 += piles[l];
                    }
                    l++;
                } else {
                    if (isFirstPlayer) {
                        System.out.println("first: " + piles[r]);
                        s1 += piles[r];
                    } else {
                        System.out.println("second: " + piles[r]);
                        s2 += piles[r];
                    }
                    r--;
                }
            }
        }

        s1 += Math.max(piles[l], piles[r]);
        System.out.println("first: " + Math.max(piles[l], piles[r]));
        s2 += Math.min(piles[l], piles[r]);
        System.out.println("second: " + Math.min(piles[l], piles[r]));
        return s1 >= s2;
    }

}
