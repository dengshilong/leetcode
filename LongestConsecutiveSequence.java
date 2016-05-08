import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i: nums) {
            map.put(i, 0);
        }
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.get(nums[i]) == 1) {
                continue;
            }
            int left = -1;
            int right = 1;
            while (map.containsKey(nums[i] + left) && map.get(nums[i] + left) == 0) {
                map.put(nums[i] + left, 1);
                left--;
                count++;
            }
            while (map.containsKey(nums[i] + right) && map.get(nums[i] + right) == 0) {
                map.put(nums[i] + right, 1);
                right++;
                count++;
            }
            result = Math.max(result, count);           
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
