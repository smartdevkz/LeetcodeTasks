package Easy;

import java.util.HashSet;

//929. Unique Email Addresses
public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> names = new HashSet<>();

        for (String str : emails) {
            StringBuilder builder = new StringBuilder();
            var arr = str.split("@");
            var name = arr[0];
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == '+') {
                    break;
                }
                if (name.charAt(i) != '.') {
                    builder.append(name.charAt(i));
                }
            }
            builder.append('@');
            builder.append(arr[1]);
            names.add(builder.toString());
        }
        return names.size();
    }
}
