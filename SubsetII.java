import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class SubsetII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0)
        	return result;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        _subsetsWithDup(temp, 0, result, new ArrayList<Integer>());
        return result; 
    }
	
	private static void _subsetsWithDup(int[] nums, int start, List<List<Integer>> result, ArrayList<Integer> cur) {
		result.add(cur);
		if (start == nums.length)
			return;
		for (int i = start; i < nums.length; i++) {
			if(start == i || nums[i] != nums[i - 1]) {
				ArrayList<Integer> temp = new ArrayList<Integer>(cur);
				temp.add(nums[i]);
				_subsetsWithDup(nums, i + 1, result, temp);
			}
        }
	}
	public static void main(String[] args) {
		int[] nums = {4, 1, 1, 0};
		List<List<Integer>> result = subsetsWithDup(nums);
		System.out.println(result.size());
		for (List<Integer> t: result) {
			for (Integer i: t) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}
