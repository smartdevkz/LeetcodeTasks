package Easy;

//704. Binary Search
public class Solution704 {

    public static void main(String[] args) {
        var app = new Solution704();
        var nums = new int[] { -1, 0, 3, 5, 9, 12 };
        var res = app.search(nums, 9);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right-left)/2;
            if(nums[pivot]==target)return pivot;
            if(nums[pivot]>target){
                right = pivot+1;
            }else{
                left = pivot-1;
            }
        }
        return -1;
    }
}
