import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {
	public static String largestNumber(int[] nums) {
		if (nums.length == 0)
			return "0";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	strs[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return (s2 + s1).compareTo(s1 + s2);
			}	
        };
        Arrays.sort(strs, comp);
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
        	sb.append(s);
        }
        return strs[0].equals(0) ? "0" : sb.toString();
    }
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}
}
