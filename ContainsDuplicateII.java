import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i])) {
        		int j = map.get(nums[i]);
        		if (i - j <= k) {
        			return true;
        		} else {
        			map.put(nums[i], i);
        		}
        	} else {
        		map.put(nums[i], i);
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{1,2,1,1}, 1));
		System.out.println(containsNearbyDuplicate(new int[]{-1, -1}, 1));
	}
}
