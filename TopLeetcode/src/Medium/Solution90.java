package Medium;

import java.util.*;

//https://leetcode.com/problems/subsets-ii/
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        int n = nums.length;

        // Sort the generated subset. This will help to identify duplicates.
        Arrays.sort(nums);

        int maxNumberOfSubsets = (int) Math.pow(2, n);
        // To store the previously seen sets.
        Set<String> seen = new HashSet<>();

        for (int subsetIndex = 0; subsetIndex < maxNumberOfSubsets; subsetIndex++) {
            // Append subset corresponding to that bitmask.
            List<Integer> currentSubset = new ArrayList();
            StringBuilder hashcode = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // Generate the bitmask
                int mask = 1 << j;
                int isSet = mask & subsetIndex;
                System.out.println("i=" + subsetIndex + ", j=" + j + ", mask=" + mask + ", isSet=" + isSet);
                if (isSet != 0) {
                    currentSubset.add(nums[j]);
                    // Generate the hashcode by creating a comma separated string of numbers in the currentSubset.
                    hashcode.append(nums[j]).append(",");
                }
            }
            System.out.println(hashcode);
            if (!seen.contains(hashcode.toString())) {
                seen.add(hashcode.toString());
                subsets.add(currentSubset);
            }

        }

        return subsets;
    }

    public static void main(String[] args) {
        //test();
        var app = new Solution90();
        var res = app.solve(new int[]{1, 2, 3});
    }

    static void test() {
        int n = 3;
        int nthBit = 1 << n;
        for (int i = 0; i < (int) Math.pow(2, n); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
            System.out.println(bitmask);
        }
    }

    static void test2() {
        int n = 3;
        int maxNumberOfSubsets = (int) Math.pow(2, n);
        for (int i = 0; i < maxNumberOfSubsets; i++) {
            for (int j = 0; j < n; j++) {
                // Generate the bitmask
                int mask = 1 << j;
                int isSet = mask & i;
                //if (isSet != 0)
                System.out.println("i=" + i + ", j=" + j + ", mask=" + mask + ", isSet=" + isSet);
            }
        }
    }

    List<List<Integer>> solve(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);

        var seen = new HashSet<String>();
        for (int i = 0; i <= Math.pow(2, n); i++) {
            var lst = new ArrayList<Integer>();
            var hashcode = new StringBuilder();
            for (int j = 0; j < n; j++) {
                var mask = 1 << j;
                if ((i & mask) == 0) continue;
                lst.add(nums[j]);
                hashcode.append(nums[j] + ",");
            }
            if (!seen.contains(hashcode.toString())) {
                res.add(lst);
                seen.add(hashcode.toString());
            }
        }
        return res;
    }
}
