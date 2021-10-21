package Easy;

//709. To Lower Case
public class Solution709 {
    public static void main(String[] args) {

    }

    public String toLowerCase(String s) {
        StringBuilder builder = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            if (ch > 'z') {
                builder.append((char) ch + 32);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
