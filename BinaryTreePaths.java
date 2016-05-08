import java.util.ArrayList;
import java.util.List;



public class BinaryTreePaths {
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> result = new ArrayList<String>();
//        if (root == null) {
//            return result;
//        }
//        String str = String.valueOf(root.val);
//        List<String> left = binaryTreePaths(root.left);
//        for (String s: left) {
//            result.add(str + "->" +  s);
//        }
//        List<String> right = binaryTreePaths(root.right);
//        for (String s: right) {
//            result.add(str + "->" + s);
//        }
//        if (result.size() == 0) {
//            result.add(str);
//        }
//        return result;
//    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        binaryTreePaths(root, "", result);
        return result;
    }
    private static void  binaryTreePaths(TreeNode root, String s, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(s + root.val);
            return;
        } else {
            String temp = s + root.val + "->";
            if (root.left != null) {
                binaryTreePaths(root.left, temp, result);
            }
            if (root.right != null) {
                binaryTreePaths(root.right, temp, result);
            }
        }
    }
    public static void main(String[] args) {
        
    }

}
