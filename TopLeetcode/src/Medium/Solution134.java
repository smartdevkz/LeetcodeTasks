package Medium;

//https://leetcode.com/problems/gas-station/
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) return -1;

        int remainingGas = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            remainingGas += (gas[i] - cost[i]);
            if (remainingGas < 0) {
                remainingGas = 0;
                start = i + 1;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        var app = new Solution134();
        var res = app.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
        System.out.println("res=" + res);
    }

}
