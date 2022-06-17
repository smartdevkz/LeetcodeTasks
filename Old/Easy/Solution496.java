package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//496. Next Greater Element I
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = getHm(nums2);
        for(int i=0;i<nums1.length;i++){
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    HashMap<Integer, Integer> getHm(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                hm.put(nums[i], nums[i + 1]);
                var iterator = hs.iterator();
                while (iterator.hasNext()) {
                    int number = iterator.next();
                    if (number < nums[i + 1]) {
                        hm.put(number, nums[i + 1]);
                        iterator.remove();
                    }
                }
            } else {
                hs.add(nums[i]);
            }
        }
        return hm;
    }
}
