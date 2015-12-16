import java.util.ArrayList;
import java.util.List;


public class PascalsTriangleII {
	public static List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        dp[0] = 1;
        if (rowIndex > 0) {
        	dp[1] = 1;
        }
        for (int i = 2; i <= rowIndex; i++) {
        	dp[i] = 1;
        	for (int j = i - 1; j > 0; j--) {
        		dp[j] = dp[j] + dp[j - 1];
        	}
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i: dp) {
        	result.add(i);
        }
        return result;
    }
	public static void main(String[] args) {
		List<Integer> result = getRow(3);
		for (Integer t: result) {
			System.out.println(t);
		}
	}
}
