import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午10:47:05 
* 
*/
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        if (root == null) {
//            return result;
//        }
//        if (root.left != null) {
//            List<Integer> left = inorderTraversal(root.left);
//            for (Integer i: left) {
//                result.add(i);
//            }
//        }
//        result.add(root.val);
//        if (root.right != null) {
//            List<Integer> right = inorderTraversal(root.right);
//            for (Integer i: right) {
//                result.add(i);
//            }
//        }
//        return result;
//    }
}
