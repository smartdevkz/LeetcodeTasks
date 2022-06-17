package Easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/design-hashmap/
public class Solution706 {

}

class MyHashMap {

    List<Integer> keys;
    List<Integer> values;

    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    private int getIndex(int key) {
        return keys.indexOf(key);
    }

    public void put(int key, int value) {
        var index = getIndex(key);
        if (index >= 0) {
            values.set(index, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        if (index == -1)
            return -1;
        return values.get(index);
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (index == -1)
            return;
        keys.remove(index);
        values.remove(index);
    }
}