
public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int s = nums[0];
        int count = 1;
        int i = 0;
        while (i < nums.length - 1 && i + s < nums.length - 1) {
            int temp = s;
            for (int j = 1; j <= s; j++) {
                temp = Math.max(nums[i + j], temp - 1);
            }
            i += s;
            s = temp;
            if (s == 0) {
                return -1;
            }
            count++;
        }
        return count;
        
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
        int[] n = {3,2,1,0,4};
        System.out.println(jump(n));
        int[] temp = {2,1};
        System.out.println(jump(temp));
    }
}
