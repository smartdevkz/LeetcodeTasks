package Medium;

import java.util.*;

//https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
public class Solution1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {

        List<List<String>> result = new ArrayList<>();

        TreeMap<Integer, HashMap<String, Integer>> treeMap = new TreeMap<>();
        var dishes = new TreeSet<String>();

        for (List<String> order : orders) {

            Integer table = Integer.parseInt(order.get(1));
            var dish = order.get(2);

            dishes.add(dish);

            if (treeMap.containsKey(table)) {
                var dishCount = treeMap.get(table).getOrDefault(dish, 0) + 1;
                treeMap.get(table).put(dish, dishCount);
            } else {
                var dishCountMap = new HashMap<String, Integer>();
                dishCountMap.put(dish, 1);
                treeMap.put(table, dishCountMap);
            }

        }

        var firstRow = new ArrayList<String>();
        firstRow.add("Table");
        firstRow.addAll(dishes);

        result.add(firstRow);

        for (var entrySet : treeMap.entrySet()) {
            var newRow = new ArrayList<String>();
            newRow.add(entrySet.getKey() + "");

            for (var d : dishes) {
                var tableDishes = entrySet.getValue();
                var count = tableDishes.getOrDefault(d, 0);
                newRow.add(count.toString());
            }

            result.add(newRow);

        }

        return result;
    }

}
