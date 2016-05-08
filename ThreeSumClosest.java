import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        assert nums.length >= 3;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        return threeSumClosest(temp, 0, temp.length - 1, target);    
    }
    private static int threeSumClosest(int[] nums, int start, int end, int target) {
        int closest = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (i > start && nums[i] == nums[i - 1]) 
                continue;
            int sum = target - nums[i];
            int j = i + 1;
            int k = end;
            while (j < k && j < end) {
                int distance = Math.abs(nums[j] + nums[k] - sum);
                if (distance < minDistance) {
                    closest = nums[i] + nums[j] + nums[k];
                    if (distance == 0)
                        return closest;
                    minDistance = distance;
                }
                if (nums[j] + nums[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 3));
    }
}
