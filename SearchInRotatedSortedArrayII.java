
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (left < right && nums[right] == nums[right - 1]) right--;
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //int[] a = {4, 5, 6, 7, 0, 1, 2};
        int[] a = {1, 3, 1, 1, 1};
        System.out.println(search(a, 3));
        System.out.println(search(a, 5));
        System.out.println(search(a, 1));
        
        System.out.println(search(new int[]{1, 3, 5}, 5));
    }
}
