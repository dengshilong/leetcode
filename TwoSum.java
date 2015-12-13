import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] defaultResult = {0, 0};
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.get(temp) != null) {
				int[] result = {map.get(temp) + 1, i + 1};
				return result;
			}
			map.put(nums[i], i);
		}
		return defaultResult;
	}
	public static void main(String[] args) {
		int[] nums = {2, 2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}
}
