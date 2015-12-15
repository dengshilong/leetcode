import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int num: temp)
        	list.add(num);
        _permuteUnique(list, 0, res);
        return res;
    }
	private static void _permuteUnique( LinkedList<Integer> nums, int start, List<List<Integer>> res){
        if (start == nums.size() - 1){
            LinkedList<Integer> temp = new LinkedList<Integer>(nums);
            res.add(temp);
            return;
        }
        for (int i = start; i < nums.size(); i++){
            if (i > start && nums.get(i) == nums.get(i - 1)) continue;
            nums.add(start, nums.get(i));
            nums.remove(i + 1);
            _permuteUnique(nums, start + 1, res);
            nums.add(i + 1, nums.get(start));
            nums.remove(start);         
        }
    }
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,2,1};
		//int[] nums = {3,3,1,2,3,2,3,1};
		List<List<Integer>> result = permuteUnique(nums);
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
