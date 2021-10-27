package Easy;

import java.util.HashMap;

//1160. Find Words That Can Be Formed by Characters
public class Solution1160 {
    public static void main(String[] args) {

    }

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        HashMap<Character, Integer> originMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            originMap.put(chars.charAt(i), originMap.getOrDefault(chars.charAt(i), 0) + 1);
        }

        for (String str : words) {
            HashMap<Character, Integer> hm = new HashMap<>(originMap);
            boolean isGood = true;
            for (int i = 0; i < str.length(); i++) {
                if (!hm.containsKey(str.charAt(i))||hm.get(str.charAt(i))<=0) {
                    isGood = false;
                    break;
                } else {
                    hm.put(str.charAt(i), hm.get(str.charAt(i)) - 1);
                }
            }
            if (isGood)
                count += str.length();
        }
        return count;
    }
}
