public class BasicCalculatorII {
	public static int calculate(String s) {
		int answer = 0;
		char op = '+';
		int preNum = 0;
		for (int i = 0; i < s.length(); i++) {
			int num = 0;
			while (i < s.length() && (s.charAt(i) == ' ' || 
					(s.charAt(i) >= '0' &&  s.charAt(i) <= '9'))) {
				char ch = s.charAt(i);
				if (ch == ' ') {
					i++;
					continue;
				}
				if (ch >= '0' && ch <= '9') {
					num = num * 10 + ch - '0';
				}
				i++;
			}
			if (op == '+') {
				answer += preNum;
				preNum = num;
			} else if (op == '-') {
				answer += preNum;
				preNum = -num;
			} else if (op == '*') {
				preNum *= num;
			} else {
				preNum /= num;
			}
			if (i < s.length()) {
				op = s.charAt(i);
			}
		}
		answer += preNum;
		return answer;
	}
//	public static int calculate(String s) {
//        Stack<Integer> operand = new Stack<Integer>();
//        Stack<String> operator = new Stack<String>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//        	char ch = s.charAt(i);
//        	if (ch == ' ')
//        		continue;
//        	if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
//        		String num = sb.toString();
//        		sb = new StringBuilder();
//        		operand.add(Integer.parseInt(num));
//        		if (operator.empty()) {
//        			operator.push(String.valueOf(ch));
//        			continue;
//        		}
//        		if (ch == '+' || ch == '-') {
//        			while (!operator.empty()) {
//        				int temp = calc(operand, operator);
//        				operand.push(temp);
//        			}
//        			operator.push(String.valueOf(ch));
//        		} else {
//        			String oper = operator.peek();
//        			if (oper.equals("*") || oper.equals("/")) {
//        				int temp = calc(operand, operator);
//        				operand.push(temp);
//            			operator.push(String.valueOf(ch));
//        			} else {
//        				operator.push(String.valueOf(ch));
//        			}
//        		}
//        	} else {
//        		sb.append(ch);
//        	}
//        }
//        String num = sb.toString();
//		operand.add(Integer.parseInt(num));
//		while (!operator.empty()) {
//			int temp = calc(operand, operator);
//			operand.push(temp);
//		}
//        return operand.pop();
//    }
//	private static int calc(Stack<Integer> operand, Stack<String> operator) {
//		int b = operand.pop();
//		int a = operand.pop();
//		String oper = operator.pop();
//		//System.out.println(operator + " " + a + " " + b);
//		if (oper.equals("+")) {
//			return a + b;
//		} else if (oper.equals("-")) {
//			return a - b;
//		} else if (oper.equals("*")) {
//			return a * b;
//		} else {
//			return a / b;
//		}
//	}
	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3/2 "));
		System.out.println(calculate(" 3+5 / 2 "));
		System.out.println(calculate("5"));
		System.out.println(calculate("5 + 2 + 1"));
		System.out.println(calculate("5 * 2 * 3"));
		System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));	
	}
}
