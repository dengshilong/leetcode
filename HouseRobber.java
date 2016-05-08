
public class HouseRobber {
    public static int rob(int[] nums) {
        int notRob = 0;
        int preNotRob = 0;
        int rob = 0;
        int preRob = 0;
        for (int n: nums) {
            rob = preNotRob + n;
            notRob = Math.max(preRob, notRob);
            preRob = rob;
            preNotRob = notRob;
        }
        return Math.max(rob, notRob);
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 4};
        System.out.println(rob(nums));
    }
}
