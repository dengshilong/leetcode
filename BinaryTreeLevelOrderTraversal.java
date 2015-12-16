import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;




public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.push(null);
        queue.push(root);
        while (!queue.isEmpty()) {
        	List<Integer> temp = new ArrayList<Integer>();
        	TreeNode cur = queue.pop();
        	while (cur != null || !queue.isEmpty()) {
        		temp.add(cur.val);
        		cur = queue.pop();
        	}
        	if (temp.size() > 0) {
        		list.add(temp);
        	}
        }
        return list;
    }
}
