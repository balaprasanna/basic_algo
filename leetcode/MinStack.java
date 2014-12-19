import java.util.*;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack(){
        stack = new Stack<Integer>();
        minStack =new Stack<Integer>();
    }
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        if(stack.empty()) return;
        int e = stack.pop();
        if(minStack.peek() == e)
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
