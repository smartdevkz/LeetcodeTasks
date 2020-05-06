package ContestMay;

public class VersionControl {
    public static void main(String[] args) {
        int n = 10;
        int res = firstBadVersion(n);
        System.out.println("res: " +res);
    }

    public static int firstBadVersion(int n) {
        int i = n;
        int left = 0;
        int right=n;
        int d = n;

        while (d > 2) {
            int direction = isBadVersion(i) ? -1 : 1;
            System.out.println("i="+i+" isBadVersion="+isBadVersion(i)+" d="+d);

            d = right-left;
            if (d < 0)
                d = d * (-1);
            i = i + (direction) * (d / 2);

            if(direction<0){
                right = i;
            }else{
                int temp = right-left;
                left = right;
                right+=temp;
            }
        }
        System.out.println("d="+d);
        return i;
    }

    public static boolean isBadVersion(int n) {
        int badVersion = 9;
        return n>=badVersion;
    }
}