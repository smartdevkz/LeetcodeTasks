public class RomanToInteger {
    public static void main(String[] args) {
        String s ="MCMXCIV";
        int res =romanToInt(s);
        System.out.println(res);
    }

    public static int romanToInt(String s) {
        int res = 0;
        int prev = 0;
        for(int i=s.length()-1;i>=0;i--){
            int n = getNum(s.charAt(i));
            if(prev>n) n = (-1)*n;
            res+=n;
            prev=n;
        }
        return res;
    }

    public static int getNum(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}