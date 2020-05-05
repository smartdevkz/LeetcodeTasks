import java.util.LinkedList;

public class RegularExpressionMatching {
    public static void main(final String[] args) {
        String s = "aaa";
        String p = "a*a";
        boolean res = isMatch(s, p);
        System.out.println("res=" + res);
    }

    public static boolean isMatch(final String s, final String p) {
        LinkedList<Pattern> lst = CreatePatternList(p);

        int i=0, j=0;
        while(i<s.length()||j<lst.size()){
            if(j>=lst.size())return false;
            if(i>=s.length()){
                if(lst.get(j).getAnyCount()){
                    j++;continue;
                }else{
                    return false;
                }
            }

            if(lst.get(j).isMatch(s.charAt(i))){
                i++;
                if(!lst.get(j).getAnyCount()){
                    j++;
                }
            }else{
                if(lst.get(j).getAnyCount()){
                    j++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
   
    public static LinkedList<Pattern> CreatePatternList(String p) {
        LinkedList<Pattern> lst = new LinkedList<>();
        int i = 0;
        while (i < p.length()) {
            if (p.charAt(i) != '*') {
                Pattern pattern = new Pattern(p.charAt(i));
                if (i + 1 < p.length()) {
                    if (p.charAt(i + 1) == '*') {
                        pattern.setAnyCount(true);
                        i++;
                    }
                }
                lst.add(pattern);
            }
            i++;
        }
        return lst;
    }
}

class Pattern {

    private char content;
    private boolean isAnyCount;

    public Pattern(char c) {
        this.content = c;
    }

    public boolean isMatch(char s) {
        if (isAny() || content == s)
            return true;
        return false;
    }

    public void setAnyCount(boolean isAnyCount) {
        this.isAnyCount = isAnyCount;
    }

    public boolean getAnyCount() {
        return this.isAnyCount;
    }

    private boolean isAny() {
        return this.content == '.';
    }

}

/*
 * class LinkedList<E> { int size; Node<E> current; Node<E> root;
 * 
 * public int size(){ return size; }
 * 
 * public boolean isEmpty() { return size == 0; }
 * 
 * public void Add(E e) { Node<E> newNode = new Node<>(e); if (isEmpty()) {
 * current = newNode; root = newNode; } else { root.setNext(newNode); } root =
 * newNode; size++; }
 * 
 * public void MoveNext(){ current = current.getNext(); }
 * 
 * public Node<E> Current(){ return current; }
 * 
 * private class Node<E> { private E element; private Node<E> next;
 * 
 * public E getValue() { return element; }
 * 
 * public Node(E e) { this.element = e; }
 * 
 * public void setNext(Node<E> n){ this.next = n; }
 * 
 * public Node<E> getNext(){ return next; } }
 * 
 * }
 */