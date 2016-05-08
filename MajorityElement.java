
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else {
                if (major != nums[i]) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return major;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1};
        System.out.println(majorityElement(nums));
    }
}
