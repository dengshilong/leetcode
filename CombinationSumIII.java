import java.util.ArrayList;
import java.util.List;


public class CombinationSumIII {
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        combinationSum3(k, n, 1, result, comb);
        return result;
    }
	private static void combinationSum3(int k, int n, int start, List<List<Integer>> result, List<Integer>comb) {
        if (n == 0 && k == 0) {
        	if (comb.size() != 0) {
        		List<Integer> temp = new ArrayList<Integer>(comb);
        		result.add(temp);
        	}
        	return;
        }
        if (k <= 0 || start > 9 || n <= 0)
        	return;
		for (int i = start; i <= 9; i++) {
			comb.add(i);
        	combinationSum3(k - 1, n - i, i + 1, result, comb);
        	comb.remove(comb.size() - 1);
        }
    }
	public static void main(String[] args) {
		List<List<Integer>> result = combinationSum3(3, 9);
		for (List<Integer> list: result) {
			for (Integer i: list) {
				System.out.print(" " + i);
			}
			System.out.println("");
		}
	}
}
