
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    private static int findKthLargest(int[] nums, int left, int right, int k) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[i] < nums[right]) i++;
            while (j > i && nums[j] >= nums[right]) j--;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        if (i - left + 1 == k) {
            return nums[i];
        } else if (i - left + 1 < k) {
            return findKthLargest(nums, i + 1, right, k - (i - left + 1));
        } else {
            return findKthLargest(nums, left, i - 1, k);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(findKthLargest(nums, 1));
        System.out.println(findKthLargest(nums, 2));
        System.out.println(findKthLargest(nums, 3));
        System.out.println(findKthLargest(nums, 4));
    }
}
