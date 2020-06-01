import java.util.ArrayList;
import java.util.List;

public class MinStackApp {

    public static void main(String[] args) {
        MinStackApp app = new MinStackApp();
        app.run();
    }

    public void run() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        display(minStack);
        minStack.push(0);
        display(minStack);
        minStack.push(-3);
        display(minStack);
        print("min: "+minStack.getMin()); // return -3
        minStack.pop();
        display(minStack);
        print("top: "+minStack.top());// return 0
        print("min: "+minStack.getMin());
    }

    void print(Object x){
        System.out.println(x);
    }

    void display(MinStack stack) {
        for (Integer item : stack.items) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    class MinStack {
        List<Integer> items;

        /** initialize your data structure here. */
        public MinStack() {
            items = new ArrayList<>();
        }

        public void push(int x) {
            items.add(0, x);
        }

        public void pop() {
            if (items.size() > 0)
                items.remove(0);
        }

        public int top() {
            return items.get(0);
        }

        public int getMin() {
            int min = items.get(0);
            for(int i=1;i<items.size();i++){
                if(items.get(i)<min)min=items.get(i);
            }
            return min;
        }
    }
}