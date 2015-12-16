import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 下午1:58:48 
* 
*/
public class BinaryTreePostorderTraversal {
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			while (!stack.isEmpty()) {
				cur = stack.peek();
				if (cur.right == pre) {
					list.add(cur.val);
					pre = cur;
					stack.pop();
					cur = null;
				} else {
					if (cur.right == null) {
						pre = null;
					}
					cur = cur.right;
					break;
				}
			}
		} 
		return list;
    }
//	public List<Integer> postorderTraversal(TreeNode root) {
//		List<Integer> list = new ArrayList<Integer>();
//		if (root == null) {
//			return list;
//		}
//		if (root.left != null) {
//			List<Integer> temp = postorderTraversal(root.left);
//			for (Integer i: temp) {
//				list.add(i);
//			}
//		}
//		if (root.right != null) {
//			List<Integer> temp = postorderTraversal(root.right);
//			for (Integer i: temp) {
//				list.add(i);
//			}
//		}
//		list.add(root.val);
//		return list;
//	}
}
