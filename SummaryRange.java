import java.util.ArrayList;
import java.util.List;


public class SummaryRange {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0)
            return result;
        int i = 0;
        for (int j = 1; j <= nums.length; j++) {
            if (j == nums.length || nums[j] > nums[j - 1] + 1) {
                String temp = String.valueOf(nums[i]);
                if (i != j - 1) {
                    temp += "->" + String.valueOf(nums[j - 1]);
                }
                result.add(temp);
                i = j;
            }    
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] a = {0,1,2,4,5,7,9};
        List<String> result = summaryRanges(a);
        for (String s:result) {
            System.out.println(s);
        }
    }

}
