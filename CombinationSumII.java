import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
         int[] temp = Arrays.copyOf(candidates, candidates.length);
         Arrays.sort(temp);
        combinationSum2(temp, target, 0, result, comb);
        return result;
    }
    private static void combinationSum2(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer>comb) {
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
            if(start == i || candidates[i] != candidates[i - 1]) {
                comb.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, result, comb);
                comb.remove(comb.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5, 1};
        int n = 9;
        List<List<Integer>> result = combinationSum2(nums, n);
        for (List<Integer> list: result) {
            for (Integer i: list) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }
}
