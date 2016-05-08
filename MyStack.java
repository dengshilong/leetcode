import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


public class MyStack {
    Deque<Integer> queue = new ArrayDeque<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.addFirst(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.removeFirst();
    }

    // Get the top element.
    public int top() {
        int e = queue.getFirst();
        return e;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
    }
}
