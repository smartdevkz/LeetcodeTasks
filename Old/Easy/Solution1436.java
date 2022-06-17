package Easy;

import java.util.HashSet;
import java.util.List;

//1436. Destination City
public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        if (paths.size() == 1)
            return paths.get(0).get(1);
        HashSet<String> hs = new HashSet<>();
        for (var pairs : paths) {
            hs.add(pairs.get(1));
        }

        for (var pairs : paths) {
            hs.remove(pairs.get(0));
        }

        return hs.iterator().next();
    }
}
