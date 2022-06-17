package DynamicProgramming;

import java.util.Map;

public class ClimbingStartApp {
    public static void main(String[] args) {
        ClimbingStartApp app = new ClimbingStartApp();
        app.run();
    }

    void run() {
        System.out.println(climbStairs(6));
    }

    public int climbStairs(int n) {
        return fib(n+1);
    }

    int fib(int n) {
        if(n==1||n==2)return 1;
        int prev1 = 1;
        int prev2 = 1;
        for(int i=3;i<=n;i++){
            int t = prev2;
            prev2 = prev1+prev2;
            prev1=t;
        }
        return prev2;
    }
}