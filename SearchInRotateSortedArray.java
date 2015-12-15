import java.util.Arrays;


public class 	 {
	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
    }
	
	
	public static void main(String[] args) {
		int[] a = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(search(a, 3));
		System.out.println(search(a, 5));
		System.out.println(search(a, 1));
	}
}
