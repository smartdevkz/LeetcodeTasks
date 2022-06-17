package ContestMay;

import java.util.HashMap;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int res = majorityElement(nums);
        System.out.println(res);
    }

    public static int majorityElement(int[] nums) {
        int k = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key = nums[i];
            if(map.containsKey(key)){
                int val = map.get(key);
                val++;
                if(val>k){
                    return key;
                }
                map.put(key, val);
            }else{
                map.put(key, 1);
            }
        }
        return nums[0];
    }

}