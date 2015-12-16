/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午11:23:43 
* 
*/
public class ConvertSortedArrayToBinarySearchTree {
	public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
	private static TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
		if (begin > end) {
			return null;
		}
		int mid = (end - begin) / 2 + begin;
		TreeNode root = new TreeNode(nums[mid]);
		TreeNode left = sortedArrayToBST(nums, begin, mid - 1);
		TreeNode right = sortedArrayToBST(nums, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
