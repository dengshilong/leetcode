/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午10:58:23 
* 
*/
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetricHelper(root.left, root.right);
        }
    }
    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else {
            if (left.val != right.val){
                return false;
            } else {
                return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        
            }
        }
    }
}
