/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午11:31:46 
* 
*/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        return leftMinDepth <= rightMinDepth ? 1 + leftMinDepth : 1 + rightMinDepth;
    }
}
