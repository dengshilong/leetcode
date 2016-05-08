import java.util.ArrayList;
import java.util.List;


public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int maxLeftDepth = 0;
        if (root.left != null)
            maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = 0;
        if (root.right != null)
            maxRightDepth = maxDepth(root.right);
        return maxLeftDepth >= maxRightDepth ? 1 + maxLeftDepth : 1 + maxRightDepth;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        list.add(root.val);
        if (root.right == null && root.left == null)
            return list;
        int maxRightDepth = maxDepth(root.right);
        int maxLeftDepth = maxDepth(root.left);
        List<Integer> temp = rightSideView(root.right);
        for (Integer i: temp) {
            list.add(i);
        }
        if (maxRightDepth < maxLeftDepth) {
            temp = rightSideView(root.left);
            for (int i = maxRightDepth; i < temp.size(); i++) {
                list.add(temp.get(i));
            }
        }
        return list;    
    }
    
}
