
public class JumpGame {
	public static boolean canJump(int[] nums) {
		int s = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (s > 0) {
				s = Math.max(s - 1, nums[i]);
			} else {
				return false;
			}
		}
		if (s > 0) {
			return true;
		} else {
			return false;
		}
    }
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(canJump(nums));
		int[] n = {3,2,1,0,4};
		System.out.println(canJump(n));
	}
}
