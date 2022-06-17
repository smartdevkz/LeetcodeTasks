package Easy;

//2006. Count Number of Pairs With Absolute Difference K
public class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int s = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])==k){
                    s++;
                }
            }
        }
        return s;
    }
}

/*
Runtime: 9 ms, faster than 35.98% of Java online submissions for Count Number of Pairs With Absolute Difference K.
Memory Usage: 41.2 MB, less than 18.92% of Java online submissions for Count Number of Pairs With Absolute Difference K.
*/