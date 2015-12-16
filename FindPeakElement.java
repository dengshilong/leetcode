
public class FindPeakElement {
	public static int findPeakElement(int[] nums) {
        int i = 0;
        while (i + 1 < nums.length && nums[i] < nums[i + 1])
        	i++;
        return i;
    }
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		System.out.println(findPeakElement(nums));
	}
}
