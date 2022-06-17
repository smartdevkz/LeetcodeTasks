package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1656 {
    class OrderedStream {
        int itemCount = 0;
        HashMap<Integer, String> hs;

        public OrderedStream(int n) {
            this.itemCount = n;
            hs = new HashMap<>();
        }

        public List<String> insert(int idKey, String value) {
            hs.put(idKey, value);
            for (int i = 1; i < idKey; i++) {
                if (!hs.containsKey(i)) {
                    return List.of();
                }
            }
            List<String> res = new ArrayList<>();

            while (hs.containsKey(idKey)) {
                res.add(hs.get(idKey));
                idKey++;
            }
            if (idKey == 1)
                return res;
            return res.size() > 1 ? res : List.of();
        }
    }
}
