import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
         int[] temp = Arrays.copyOf(candidates, candidates.length);
         Arrays.sort(temp);
        combinationSum(temp, target, 0, result, comb);
        return result;
    }
    private static void combinationSum(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer>comb) {
        if (target == 0) {
            if (comb.size() != 0) {
                List<Integer> temp = new ArrayList<Integer>(comb);
                result.add(temp);
            }
            return;
        }
        if (target < 0 || start == candidates.length)
            return;
        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, result, comb);
            comb.remove(comb.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {8, 7, 4, 3};
        int n = 11;
        List<List<Integer>> result = combinationSum(nums, n);
        for (List<Integer> list: result) {
            for (Integer i: list) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }
}
