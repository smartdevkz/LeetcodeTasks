package Medium;

//https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
public class Solution1061 {


    int[] representatives = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        for (int i = 0; i < 26; i++) {
            representatives[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            performUnion(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            var c = (char) (find(baseStr.charAt(i) - 'a') + 'a');
            stringBuilder.append(c);
        }
        return stringBuilder.toString();

    }

    int find(int x) {
        if (representatives[x] == x) {
            return x;
        }
        return representatives[x] = find(representatives[x]);
    }

    void performUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        if (x > y) {
            representatives[x] = y;
        } else {
            representatives[y] = x;
        }
    }

    public static void main(String[] args) {

    }
}
