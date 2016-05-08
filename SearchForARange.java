import java.util.Arrays;


public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            res[0] = res[1] = -1;
        } else {
            int start = index;
            int end = index;
            while (start >= 0 && nums[start] == target) {
                start--;
            }
            res[0] = start + 1;
            while (end < nums.length && nums[end] == target) {
                end++;
            }
            res[1] = end - 1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, 8);
        for (int i: res) {
            System.out.println(i + " ");
        }
    }
}
