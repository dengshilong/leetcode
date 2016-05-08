/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月15日 下午10:10:59 
* 
*/
public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int cur = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[cur] || nums[i] != nums[cur - 1]) {
                cur++;
                nums[cur] = nums[i];
            }   
        }   
        return cur + 1;  
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        for (int i = 0; i < nums.length; i++) 
            System.out.print(nums[i] + " ");
        System.out.println("");
        int n = removeDuplicates(nums);
        for (int i = 0; i < n; i++) 
            System.out.print(nums[i] + " ");
    }
}
