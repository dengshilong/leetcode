/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月15日 下午9:13:37 
* 
*/

public class SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        while (up <= down) {
        	int mid = (down - up) / 2 + up;
        	if (matrix[mid][0] == target) {
        		return true;
        	} else if (matrix[mid][0] > target) {
        		down = mid - 1;
        	} else {
        		up = mid + 1;
        	}
        }
        if (up <= 0) {
        	return false;
        }
        int row = up - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
        	int mid = (right - left) / 2 + left;
        	if (matrix[row][mid] == target) {
        		return true;
        	} else if (matrix[row][mid] > target) {
        		right = mid - 1;
        	} else {
        		left = mid + 1;
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		int[][] nums = {{1, 3, 5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(searchMatrix(nums, 16));
	}
}

