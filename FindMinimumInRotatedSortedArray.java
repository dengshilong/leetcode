
public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left < right) {
			mid = (right - left) / 2 + left;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
        return nums[left];
    }
	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
		System.out.println(findMin(nums));
	}
}
