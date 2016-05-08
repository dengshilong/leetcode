import java.util.Stack;

public class LongestValidParentheses {
//    public static int longestValidParentheses(String s) {
//        int result = 0;
//        int count = 0;
//        int length = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (ch == '(') {
//                count++;
//                length++;
//            } else {
//                if (count > 0) {
//                    length++;
//                    count--;
//                    if (count == 0) {
//                        result = Math.max(result, length);
//                    }
//                } else {
//                    length = 0;
//                    count = 0;
//                }
//            }
//        }
//        length = 0;
//        count = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            char ch = s.charAt(i);
//            if (ch == ')') {
//                count++;
//                length++;
//            } else {
//                if (count > 0) {
//                    length++;
//                    count--;
//                    if (count == 0) {
//                        result = Math.max(result, length);
//                    }
//                
//                } else {
//                    length = 0;
//                    count = 0;
//                }
//            }
//        }
//        return result;
//    }
//    public static int longestValidParentheses(String s) {
//        boolean[] used = new boolean[s.length()];
//        Stack<Integer> stack = new Stack<Integer>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                if (!stack.empty()) {
//                    used[i] = true;
//                    used[stack.peek()] = true;
//                    stack.pop();
//                }
//            }
//        }
//        int result = 0;
//        int length = 0;
//        for (int i = 0; i < used.length; i++) {
//            if (used[i]) {
//                length++;
//                result = Math.max(result, length);
//            } else {
//                length = 0;
//            }
//        }
//        return result;
//    }
//    public static int longestValidParentheses(String s) {
//        Stack<Integer> stack = new Stack<Integer>();
//        int start = -1;
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                if (!stack.empty()) {
//                    stack.pop();
//                    if (!stack.empty()) {
//                        result = Math.max(result, i - stack.peek());
//                    } else {
//                        result = Math.max(result, i - start);
//                    }
//                } else {
//                    start = i;
//                }
//            }
//        }
//        return result;
//    }
    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    if (dp[i - 1] > 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("(((()()"));
        System.out.println(longestValidParentheses(")))())("));
        System.out.println(longestValidParentheses("()(()"));
        
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses("(()())"));
    }
}
