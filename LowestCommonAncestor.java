

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right == null) {
			return left;
		} else if (left == null && right != null) {
			return right;
		} else if(left == null && right == null) {
			return null;
		} else {
		    return root;
		}
    }
}
