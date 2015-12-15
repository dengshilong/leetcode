

public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) 
			i--;
		if (i < 0) {
			reverse(nums, 0, nums.length - 1);
		} else {
			int j = nums.length - 1;
			while (j > i && nums[i] >= nums[j])
				j--;
			swap(nums, i, j);
			reverse(nums, i + 1, nums.length - 1);
		}	
    }
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void reverse(int[] nums, int begin, int end) {
		while (begin < end) {
			swap(nums, begin, end);
			begin++;
			end--;
		}
	}
	public static void main(String[] args) {
		int[] nums = {5, 1, 1};
		nextPermutation(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i]);
		}
		System.out.println("");
	}
}
