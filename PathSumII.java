import java.util.ArrayList;
import java.util.List;

/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午11:36:35 
* 
*/
public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
        	return result;
        pathSum(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
	private static  void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {	
		if (root.left == null && root.right == null && root.val == sum) {
			List<Integer> temp = new ArrayList<Integer>(path);
			temp.add(root.val);
			result.add(temp);
			return;
		} else {
			path.add(root.val);
			if (root.left != null) {
				pathSum(root.left, sum - root.val, path, result);
			}
			if (root.right != null) {
				pathSum(root.right, sum - root.val, path, result);
			}
			path.remove(path.size() - 1);
		}	
	}
}
