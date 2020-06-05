package BinarySearch;

public class SearchInsertApp {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        if(target<=nums[0])return 0;
        if(target>nums[nums.length-1])return nums.length;
        if(target==nums[nums.length-1])return nums.length-1;

        int l=0, r = nums.length-1, k = 0;
        while(r-l>1){
            k = (l+r)/2;
            if(nums[k]>target){
                r=k;
            }else if(nums[k]<target){
                l=k;
            }else return k;
        }
        return nums[k]>target?k:k+1;
    }
}