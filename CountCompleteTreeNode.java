


public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {  
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        for (TreeNode cur = root.left; cur != null; cur = cur.left)  leftDepth++;
        for (TreeNode cur = root.right; cur != null; cur = cur.right)  rightDepth++;
        if (leftDepth == rightDepth) {
            return 2 << leftDepth - 1;
        } 
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    
}
