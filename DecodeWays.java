
public class DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.equals(""))
            return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') 
            dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            int temp = Integer.parseInt(s.substring(i - 2, i));
            if (10 <= temp && temp <= 26) {
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                if (s.charAt(i - 1) == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            
        }
        return dp[length];
    }
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("12434"));
        System.out.println(numDecodings("1"));
        System.out.println(numDecodings("1020"));
        System.out.println(numDecodings("10000"));
        System.out.println(numDecodings("230"));
    }
    
}
