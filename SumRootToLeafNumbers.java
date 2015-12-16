import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
	 public static int sumNumbers(TreeNode root) {	
        int sum = 0;
        if (root == null)
        	return sum;
        List<Integer> path = new ArrayList<Integer>();
        List<Integer> values = new ArrayList<Integer>();
        sumNumbers(root, path, values);
        for (Integer i: values) {
        	sum += i;
        }
        return sum;
    }
	private static void sumNumbers(TreeNode root, List<Integer> path, List<Integer> values) {
		if (root.left == null && root.right == null) {
			int temp = 0;
			for (Integer i: path) {
				temp = temp * 10 + i;
			}
			temp = temp * 10 + root.val;
			values.add(temp);
		} 
		path.add(root.val);
		if (root.left != null) {
			sumNumbers(root.left, path, values);		
		}
		if (root.right != null) {
			sumNumbers(root.right, path, values);
		} 
		path.remove(path.size() - 1);	
	}
}
