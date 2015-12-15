/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月15日 下午9:14:22 
* 
*/
public class SearchA2DMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
        	if (matrix[i][j] > target) {
        		j--;
        	} else if (matrix[i][j] < target) {
        		i++;
        	} else {
        		return true;
        	}   	
        }
        return false;
    }
	public static void main(String[] args) {
		int[][] nums = {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(nums, 17));
	}
}
