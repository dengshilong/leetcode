import java.util.Arrays;

/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月15日 下午10:02:01 
* 
*/
public class SortColors {
	public static void sortColors(int[] nums) {
		int i = 0;
	    int j = 0;
	    int k = nums.length - 1;
	    while (i <= k) {
	        if (nums[i] == 0) {
	            if (i != j) {
	                swap(nums, i, j);
	            }
	            j++;
	            i = j;
	        } else if (nums[i] == 2) {
	            swap(nums, i, k);
	            k--;
	        } else {
	            i++;
	        }
	    }
    }
	private static void swap(int[] nums, int i, int j) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
	public static void main(String[] args) {
		int[] nums = {1, 0, 1, 2, 0, 1};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
