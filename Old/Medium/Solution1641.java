package Medium;

//https://leetcode.com/problems/count-sorted-vowel-strings/
public class Solution1641 {
    public int countVowelStrings(int n) {
        int count_a=1, count_e=1, count_i=1, count_o=1, count_u=1;
       if(n==1)
           return 5;
        
       for(int i=2; i<=n; i++){
           count_a= count_a+ count_e+ count_i+ count_o+ count_u;
           count_e= count_e+ count_i+ count_o+ count_u;
           count_i= count_i+ count_o+ count_u;
           count_o= count_o+ count_u;
           count_u= count_u;
       }
       return count_a+ count_e+ count_i+ count_o+ count_u;
   }
}
    