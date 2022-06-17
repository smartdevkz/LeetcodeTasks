package Easy;

//https://leetcode.com/problems/design-hashset/
public class Solution705 {
    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(1);
        hs.add(2);
        hs.contains(1);
        hs.contains(3);
        hs.add(2);
        hs.contains(2);
        hs.remove(2);
        hs.contains(2);
    }

}

/**
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains",
 * "remove", "contains"] [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 */
class MyHashSet {

    List<Integer> lst;

    public MyHashSet() {
        lst = new ArrayList<>();
    }

    public void add(int key) {
        if (!lst.contains(key))
            lst.add(key);
    }

    public void remove(int key) {
        if (lst.contains(key)) {
            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i) == key) {
                    lst.remove(i);
                }
            }
        }
    }

    public boolean contains(int key) {
        return lst.contains(key);
    }
}
