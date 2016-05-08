import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> element;
    ArrayList<Integer> min;
    MinStack() {
        element = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
    }
    public void push(int x) {
        element.add(x);
        if (min.isEmpty()) {
            min.add(x);
        } else {
            min.add(Math.min(x, min.get(min.size() - 1)));
        }
    }

    public void pop() {
        if (element.isEmpty())
            return;
        element.remove(element.size() - 1);
        min.remove(min.size() - 1);
    }

    public int top() {
        return element.get(element.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}
