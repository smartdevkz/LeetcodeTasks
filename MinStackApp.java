import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        print("min: " + minStack.getMin()); // return -3
        minStack.pop();
        display(minStack);
        print("top: " + minStack.top());// return 0
        print("min: " + minStack.getMin());
    }

    void print(Object x) {
        System.out.println(x);
    }

    void display(MinStack stack) {
        /*
         * for (Integer item : stack.items) { System.out.print(item + " "); }
         */
        System.out.println("");
    }

    class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek()))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}