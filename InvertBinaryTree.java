
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.right);
            invertTree(root.left);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
