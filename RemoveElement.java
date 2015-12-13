
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[cur++] = nums[i];
			}
		}
	    return cur;
    }
	public static void main(String[] args) {
		int[] a = {1,3,5,1,4};
		System.out.println(removeElement(a, 1));
	}
}
