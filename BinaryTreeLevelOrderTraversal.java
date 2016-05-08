import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;




public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        if (root == null) {
            return list;
        }
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode node: level) {
                temp.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            list.add(temp);
            level = nextLevel;
        }
        return list;
    }
}
