package Easy;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (truckSize == 0)
            return 0;
        int maxIndex = -1;
        int unitCount = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i] == null)
                continue;
            if (unitCount < boxTypes[i][1]) {
                unitCount = boxTypes[i][1];
                maxIndex = i;
            }
        }
        if (maxIndex == -1)
            return 0;
        int boxCount = boxTypes[maxIndex][0];
        if (boxCount < truckSize) {
            truckSize -= boxCount;
            boxTypes[maxIndex] = null;
            return boxCount * unitCount + maximumUnits(boxTypes, truckSize);
        } else {
            return truckSize * boxTypes[maxIndex][1];
        }
    }

}
