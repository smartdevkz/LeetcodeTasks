package Easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    lst.add(list1[i]);
                }
            }
        }
        return lst.toArray(new String[0]);
    }
}
