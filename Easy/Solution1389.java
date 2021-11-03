package Easy;

import java.util.ArrayList;
import java.util.List;

//1389. Create Target Array in the Given Order
public class Solution1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<index.length;i++){
            int ix = index[i];
            int val = nums[i];
            lst.add(ix, val);
        }
        return lst.stream().mapToInt(i->i).toArray();
    }
}
