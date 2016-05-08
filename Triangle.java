import java.util.List;


public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows];
        for (int i = 0; i < rows; i++) {
            List<Integer> temp = triangle.get(i);
            if (i > 0)
                dp[i] = temp.get(i) + dp[i - 1];    
            for (int j = i - 1; j >= 1; j--) {
                dp[j] = temp.get(j) + Math.min(dp[j], dp[j - 1]);
            }
            dp[0] = temp.get(0) + dp[0];
        }
        
        int minNum = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] < minNum)
                minNum = dp[i];
        }
        return minNum;    
    }
}
