
public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		int left = 0;
	    int right = nums.length - 1;
	    while (left <= right) {
	        int mid = (left - right) / 2 + right;
	        if (nums[mid] == target) {
	            return mid;
	        } else if (nums[mid] > target) {
	            right = mid - 1;
	        } else {
	            left = mid + 1;
	        }
	    }
	    return left;
    }
	public static void main(String[] args) {
		int[] nums = {1, 3, 3, 4};
		System.out.println(searchInsert(nums, 3));
	}
}
