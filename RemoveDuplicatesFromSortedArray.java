
public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums.length < 2)
	        return nums.length;
	    int cur = 0;
	    for (int i = 1; i < nums.length; i++) {
	        if (nums[i] != nums[cur]) {
	            nums[++cur] = nums[i];
	        }   
	    }   
	    return cur + 1;  
    }
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		int n = removeDuplicates(nums);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
