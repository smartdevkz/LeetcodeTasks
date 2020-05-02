public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5};
        int res = maxArea(arr);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        if(height.length<2)return 0;
        

        int max = 0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int d = j-i;
                int h = height[i]<height[j]?height[i]:height[j];
                int s = d*h;
                if(max<s)max=s;
            }
        }
        return max;
    }
}