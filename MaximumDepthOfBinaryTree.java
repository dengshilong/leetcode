/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午11:05:09 
* 
*/
public class MaximumDepthOfBinaryTree {
	public static int maxDepth(TreeNode root) {
		if (root == null) {
	        return 0;
	    }
	    int maxLeftDepth = 0;
	    if (root.left != null)
	        maxLeftDepth = maxDepth(root.left);
	    int maxRightDepth = 0;
	    if (root.right != null)
	        maxRightDepth = maxDepth(root.right);
	    return maxLeftDepth >= maxRightDepth ? 1 + maxLeftDepth : 1 + maxRightDepth;
    }
}
