import java.util.ArrayList;
import java.util.List;


public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 0 || n == 0) {
            return result;
        }
        combine(1, n, k, result, new ArrayList<Integer>());
        return result;
    }
    private static void combine(int start, int end, int k, List<List<Integer>> result, List<Integer> com) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(com));
            return;
        }
        for (int i = start; i <= end; i++) {
            com.add(i);
            combine(i + 1, end, k - 1, result, com);
            com.remove(com.size() - 1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        for (List<Integer> t: result) {
            for (Integer i: t) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
