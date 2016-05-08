import java.util.ArrayList;


public class PermutationSequence {
    public static final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public static String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++)
            nums.add(i + 1);
        return getPermutation(nums, k - 1, "");
    }
    private static String getPermutation(ArrayList<Integer> nums, int k, String result) {
        if (nums.size() == 1) {
            return result + nums.get(0);
        }
        int t = factorial[nums.size() - 1];
        int index = k / t;
        int temp = nums.get(index);
        nums.remove(index);
        return getPermutation(nums, k - index * t, result + temp);
    }
    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 24; i++) {
            System.out.println((i + 1) + " " + getPermutation(4, i + 1));
        }
        System.out.println(getPermutation(4, 10));
        System.out.println(getPermutation(2, 2));
        System.out.println(getPermutation(8, 8590));
    }
}
