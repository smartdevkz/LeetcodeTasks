package Contest;

import java.util.Arrays;

public class Solution6285 {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        Arrays.sort(nums);

        int idx = nums.length - 1;

        while (k > 0) {
            System.out.println("before: ");
            display(nums);
            score += nums[idx];
            System.out.println("idx: " + idx + " max: " + nums[idx] + " score: " + score);
            k--;
            nums[idx] = ceil(nums[idx], 3);
            if (idx == 0) {
                idx = nums.length - 1;
            } else {
                if (nums[idx] < nums[idx - 1]) idx--;
            }
        }

        return score;
    }


    int ceil(int num, int div) {
        return num % div == 0 ? num / div : (num / div) + 1;
    }

    void display(int[] nums) {
        //System.out.println();
        for (var item : nums) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var app = new Solution6285();
        var res = app.maxKelements(new int[]{756902131, 995414896, 95906472, 149914376, 387433380, 848985151}, 6);
        System.out.println(res);
    }

    //2476180565

    //3603535575
}
