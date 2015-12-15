import java.util.ArrayList;
import java.util.List;


public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return result;
		permute(nums, 0, result);
		reverse(nums, 0, nums.length - 1); //after permutation, we need to reverse array
		return result;
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
	private static void permute(int[] nums, int start, List<List<Integer>> result) {
		if (start == nums.length - 1) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				temp.add(nums[i]);
			}
			result.add(temp);
			return;
		}
		int i = nums.length;
		while (i > start) {
			permute(nums, start + 1, result);
			swap(nums, start, i - 1);
			i--;
			if (i <= start)
				break;
			reverse(nums, start + 1, nums.length - 1);	
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		List<List<Integer>> result = permute(nums);
		for (List<Integer> list: result) {
			for (Integer i: list) {
				System.out.print(i);
			}
			System.out.println("");
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i]);
		}
	}
}
