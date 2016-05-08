
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = 0;
            int fast = 0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while (slow != fast) {
                slow = nums[slow];
                System.out.println(fast);
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 4, 4, 5};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate(new int[]{26,86,31,31,60,31,31,31,66,31,31,31,15,31,31,31,31,63,31,31,31,64,91,31,84,31,31,31,31,31,65,31,31,75,31,43,31,31,31,31,31,31,31,29,31,42,31,31,50,31,31,31,35,55,31,31,37,31,31,31,25,31,68,31,31,31,31,31,31,31,31,31,31,31,31,31,31,31,31,59,31,23,56,31,31,92,31,31,31,31,31,31,31,94,31,16,31,31,31,31}));
    }
}
