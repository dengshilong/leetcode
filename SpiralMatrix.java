import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0)
			return list;
		int[] stepX = {0, 1, 0, -1};
		int[] stepY = {1, 0, -1, 0};
		int direction = 0;
		int i = 0;
		int j = 0;
		int count = 1;
		int M = matrix.length;
		int N = matrix[0].length;
		list.add(matrix[0][0]);
		while (count < M * N) {
			int x = i + stepX[direction];
			int y = j + stepY[direction];
			
			if (x >= 0 && x < M && y >= 0 && y < N && !list.contains(matrix[x][y])) {
				i = x;
				j = y;
				list.add(matrix[i][j]);
				count++;
				
			} else {
				direction = (direction + 1 + 4) % 4;
			}
			
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> list = spiralOrder(matrix);
		for (Integer i: list) {
			System.out.print(" " + i);
		}
	}
	
}
