import java.util.ArrayList;
import java.util.List;

/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 上午11:17:08 
* 
*/
public class BinaryTreeLevelOrderTraversalII {
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null)
            return list;
        List<List<Integer>> temp = levelOrder(root);
        for (int i = temp.size() - 1; i >= 0; i--) {
            list.add(temp.get(i));
        }
        return list;
    }
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
