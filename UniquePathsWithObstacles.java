
public class UniquePathsWithObstacles {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		int i = 0;
		int j = 0;
		while (i < m && obstacleGrid[i][0] == 0) {
			dp[i][0] = 1;
			i++;
		}
		while (j < n && obstacleGrid[0][j] == 0) {
			dp[0][j] = 1;
			j++;
		}
		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[m - 1][n - 1]; 
    }
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
}
