
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } 
        if (root.val == p.val || root.val == q.val) {
            return root;
        } 
        if ((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)) {
            return root;
        }
        if (root.left != null && (root.val > p.val && root.val > q.val)) {
           TreeNode temp = lowestCommonAncestor(root.left, p, q);
            if (temp != null)
                return temp;
        }
        if (root.right != null && (root.val < p.val && root.val < q.val)) {
            TreeNode temp = lowestCommonAncestor(root.right, p, q);
            if (temp != null)
                return temp;
        }
        return null;
    }
}
