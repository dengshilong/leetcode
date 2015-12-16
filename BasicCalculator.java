import java.util.Stack;

public class BasicCalculator {
	public static int calculate(String s) {
		Stack<Integer> operand = new Stack<Integer>();
		Stack<String> operator = new Stack<String>();
		int num = 0;
		boolean needPush = false;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ')
				continue;
			if (ch == '+' || ch == '-' || ch == '(' || ch == ')') {
				if (needPush)
					operand.push(num);
				num = 0;
				needPush = false;			
				if (ch == '(') {
					operator.push("(");
				} else if (ch == ')') {
					while (!operator.isEmpty() && !operator.peek().equals("(")) {
						int temp = calc(operand, operator);
						operand.push(temp);
					}
					operator.pop();
				} else {
					while (!operator.isEmpty() && !operator.peek().equals("(")) {
						int temp = calc(operand, operator);
						operand.push(temp);
					}
					operator.push(String.valueOf(ch));
				}
			} else {
      			num = num * 10 + ch - '0';
      			needPush = true;
			}
		}
		if (needPush)
			operand.add(num);
		while (!operator.empty()) {
			int temp = calc(operand, operator);
			operand.push(temp);
		}
		return operand.pop();
    }
	public static int calc(Stack<Integer> operand, Stack<String> operator) {
		int b = operand.pop();
		int a = operand.pop();
		String oper = operator.pop();
		if (oper.equals("+")) {
			return a + b;
		} else {
			return a - b;
		} 
	}
	public static void main(String[] args) {
		System.out.println(calculate("3+(2- 2)"));
		System.out.println(calculate("(3+(2- 2)) + (2 + 1)"));
		System.out.println(calculate("5"));
		System.out.println(calculate("5 + 2 + 1"));
		
	}
}
