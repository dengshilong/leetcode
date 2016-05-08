import java.util.Arrays;


public class HIndex {
    public static int hIndex(int[] citations) {
        int[] nums = Arrays.copyOf(citations, citations.length);
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int result = 0;
        int length = 0;
        int i = 0;
        while (i + result <= nums.length) {
            if (nums[i] >= length) {
                if (nums.length - i >= length) {
                    result = Math.max(length, result);
                    length++;
                }
            } else {
                i++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
        System.out.println(hIndex(new int[]{1, 2, 3, 100}));
        System.out.println(hIndex(new int[]{0}));
    }
}
