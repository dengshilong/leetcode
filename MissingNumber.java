
public class MissingNumber {
    public static int missingNumber(int[] nums) {  
        int sum = (nums.length + 1) * nums.length / 2;
        for (int i: nums) {
            sum -= i;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        System.out.println(missingNumber(nums));
    }
}
