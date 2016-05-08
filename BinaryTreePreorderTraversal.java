import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 下午1:55:20 
* 
*/
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        if (root == null) {
//            return list;
//        }
//        list.add(root.val);
//        if (root.left != null) {
//            List<Integer> temp = preorderTraversal(root.left);
//            for (Integer i: temp) {
//                list.add(i);
//            }
//        }
//        if (root.right != null) {
//            List<Integer> temp = preorderTraversal(root.right);
//            for (Integer i: temp) {
//                list.add(i);
//            }
//        }
//        return list;
//    }
}
