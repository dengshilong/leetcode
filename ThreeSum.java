import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length <= 2)
            return result;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        result = threeSum(temp, 0, temp.length - 1, 0);
        return result;
    }
    private static List<List<Integer>> threeSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = start; i < end; i++) {
            if (i > start && nums[i] == nums[i - 1]) 
                continue;
            int sum = target - nums[i];
            int j = i + 1;
            int k = end;
            while (j < k && j < end) {
                if (nums[j] + nums[k] == sum) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> list: result) {
            for (Integer i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
