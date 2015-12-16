
public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] last = new int[nums.length];
		int length = 0;
		last[length] = nums[0];
		length++;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > last[length - 1]) {
				last[length] = nums[i];
				length++;
			} else if (nums[i] < last[0]) {
				last[0] = nums[i];
			} else {
				int left = 1;
				int right = length - 1;
				while (left <= right) {
					int mid = (right - left) / 2 + left;
					if (last[mid] >= nums[i]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}
				last[right + 1] = nums[i];
			}
		}
		return length;	
	}
	public static void main(String[] args) {
		int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
		System.out.println(lengthOfLIS(nums));
	}
}
