import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int m = (int)Math.sqrt(Integer.MAX_VALUE);
            int j = 1;
            int min = Integer.MAX_VALUE;
            while (j <= m && j * j <= i) {
                min = Math.min(min, 1 + dp[i - j * j]);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
//    public static int numSquares(int n) {
//        Queue<Integer> queue = new ArrayDeque<Integer>();
//        Set<Integer> visited = new HashSet<Integer>();
//        queue.add(n);
//        int length = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int m = queue.poll();
//                int max = (int)Math.sqrt(Integer.MAX_VALUE);
//                int j = 1;
//                while (j <= max && j * j <= m) {
//                    if (j * j == m) {
//                        return length + 1;
//                    } else {
//                        if (!visited.contains(m - j * j))
//                            queue.add(m - j * j);
//                    }
//                    j++;
//                }
//            }
//            length++;
//        }
//        return length;
//    }
    
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(7168));
    }
}
