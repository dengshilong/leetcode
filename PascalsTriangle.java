import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            List<Integer> pre = null;
            if (i - 2 > 0)
                pre = result.get(i - 2);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(pre.get(j - 1) + pre.get(j));
                }
            }
            result.add(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = generate(4);
        for (List<Integer> t: result) {
            for (Integer i: t) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
