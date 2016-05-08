import java.util.Stack;


public class EvaluateReversePolishNotation {
     public static int evalRPN(String[] tokens) {
         Stack<Integer> stack = new Stack<Integer>();
         for (String s: tokens) {
             if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                 int b = stack.pop();
                 int a = stack.pop();
                 if (s.equals("+")) {
                     stack.push(a + b);
                 } else if (s.equals("-")) {
                     stack.push(a - b);
                 } else if (s.equals("*")) {
                     stack.push(a * b);
                 } else {
                     stack.push(a / b);
                 }
             } else {
                 stack.push(Integer.valueOf(s));
             }    
         }
         return stack.pop();
     }
     public static void main(String[] args) {
         String[] tokens = {"2", "1", "+", "3", "*"};
         System.out.println(evalRPN(tokens));
     }
}
