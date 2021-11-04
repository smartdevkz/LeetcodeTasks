package Easy;

//942. DI String Match
public class Solution942 {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];

        int min = 0;
        int max = s.length();

        int i = 0;
        for (Character ch : s.toCharArray()) {
            if(ch == 'I'){
                res[i] = min;
                min++;
            }else{
                res[i] = max;
                max++;
            }
            i++;
        }
        res[i] = min;
        return res;
    }
}
