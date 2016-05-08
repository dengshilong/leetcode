/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午11:26:00 
* 
*/
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        if (Math.abs(maxLeftDepth - maxRightDepth) > 1)
            return false;
        if (root.left != null && !isBalanced(root.left))
            return false;
        if (root.right != null && !isBalanced(root.right))
            return false;
        return true;
    }
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
