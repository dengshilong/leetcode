import java.util.Stack;

public class ImplementQueueUsingStacks {
	private Stack<Integer> head = new Stack<Integer>();
	private Stack<Integer> tail = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        tail.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (head.isEmpty()) {
        	while (!tail.isEmpty()) {
        		head.push(tail.pop());
        	}
        }
        head.pop();
    }

    // Get the front element.
    public int peek() {
    	if (head.isEmpty()) {
        	while (!tail.isEmpty()) {
        		head.push(tail.pop());
        	}
        }
        return head.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return head.isEmpty() && tail.isEmpty();
        
    }
    public static void main(String[] args) {
    	MyQueue queue = new MyQueue();
    	queue.push(2);
    	queue.push(3);
    	System.out.println(queue.peek());
    }
}
