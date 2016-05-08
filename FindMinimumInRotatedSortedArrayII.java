
public class FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            
            mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                while (mid < right && nums[mid] == nums[right]) right--;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 3, 1, 3, 3, 3}));
        System.out.println(findMin(new int[]{3, 5, 6, 7, 7, 1, 3, 3, 3}));
        System.out.println(findMin(new int[]{3, 3, 1, 3}));
        System.out.println(findMin(new int[]{1, 1, 3, 1}));
    }
}
