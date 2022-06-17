package Easy;

//1678. Goal Parser Interpretation
public class Solution1678 {
    public String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        String current = "";
        for (var ch : command.toCharArray()) {
            current += ch;
            if (current.equals("G")) {
                builder.append('G');
                current = "";
            } else if (current.equals("()")) {
                builder.append('o');
                current = "";
            } else if (current.equals("(al)")) {
                builder.append("al");
                current = "";
            }
        }
        return builder.toString();
    }
}
