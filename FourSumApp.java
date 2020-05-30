import java.util.List;
import java.util.*;

public class FourSumApp {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        int target = -11 ;        
        List<List<Integer>> res = fourSum(nums, target);
        displayList(res);
    }

    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int k = 1; k < n; k++) {
            int cur = nums[k];
            int j = k;
            while (j > 0 && nums[j - 1] > cur) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = cur;
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4||nums==null) return res;
     
        insertSort(nums);
        
        int i=0;
        Integer prevI =null; 
        while(i<nums.length-3){
            if(prevI!=null&&prevI==nums[i]){
                i++; 
                continue;
            }
            if(shouldBeBreaked(nums[i], target))break;
            int j=i+1;
            Integer prevJ = null;
            while(j<nums.length-2){
                if(prevJ!=null&&prevJ==nums[j]){
                    j++;
                    continue;
                }
                if(shouldBeBreaked(nums[i]+nums[j],target)){
                    break;
                }
                int k = j+1;
                Integer prevK = null;
                while(k<nums.length-1){
                    if(prevK!=null&&prevK==nums[k]){
                        k++;
                        continue;
                    }
                    if(shouldBeBreaked(nums[i]+nums[j]+nums[k],target)){
                        break;
                    }
                    int l = k+1;
                    Integer prevL = null;
                    while(l<nums.length){
                        if(prevL!=null&&prevL==nums[l]){
                            l++;
                            continue;
                        }
                        int sum =nums[i]+nums[j]+nums[k]+nums[l]; 
                        if(sum==target){
                            AddToList(res, nums[i], nums[j], nums[k], nums[l]);
                            break;
                        }
                        if(shouldBeBreaked(sum,target)){
                            break;
                        }
                        prevL = nums[l];
                        l++;
                    }
                    prevK = nums[k];
                    k++;
                }
                prevJ = nums[j];
                j++;
            }
            prevI = nums[i];
            i++;
        }
        return res;
    }

    static boolean shouldBeBreaked(int sum, int target){
        if(target>=0&&sum>target)return true;
        if(target<0&&sum>=0)return true;
        return false;
    }

    public static void AddToList(List<List<Integer>> res, int a, int b, int c, int d){
        List<Integer> lst = new ArrayList<>();
        lst.add(a);
        lst.add(b);
        lst.add(c);
        lst.add(d);
        res.add(lst);
    }

    static void displayRow(int a, int b, int c, int d){
        System.out.println(a+" "+b+" "+c+" "+d);
    }

    public static void displayList(List<List<Integer>> res){
        for (List<Integer> list : res) {
            for (Integer item : list) {
                System.out.print(item+" ");
            }
            System.out.println("");
        }

    }
}