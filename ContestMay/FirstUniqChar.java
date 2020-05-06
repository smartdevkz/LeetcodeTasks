package ContestMay;

import java.util.Hashtable;

public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "aadadaad";
        int res = firstUniqChar(s);
        System.out.println(res);
    }

    public static int firstUniqChar2(String s) {

        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length() - 1; i++) {
            if (arr[i] > 0)
                continue;
            arr[i] = 1;
            boolean isUnique = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    arr[j] = 1;
                    isUnique = false;
                }
            }
            if (isUnique)
                return i;
        }
        return -1;
    }

    public static int firstUniqChar(String s) {

        Hashtable<Character,Integer> dict = new Hashtable<>();

        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            if(dict.containsKey(key)){
                int val = dict.get(key);
                val++;
                dict.put(key, val);
            }else{
                dict.put(key, 1);
            }
        }



        return -1;
    }

}