import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length <= 3)
			return result;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for (int i = 0; i < temp.length - 3; i++) {
        	if (i > 0 && temp[i] == temp[i - 1])
        		continue;
        	List<List<Integer>> inter = threesum(temp, i + 1, temp.length - 1, target - temp[i]);
        	for (List<Integer> cur: inter) {
        		ArrayList<Integer> list = new ArrayList<Integer>(cur);
        		list.add(0, temp[i]);
        		result.add(list);	
        	}
        }
        return result;
    }
	private static List<List<Integer>> threesum(int[] nums, int start, int end, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	    for (int i = start; i < end; i++) {
	    	if (i > start && nums[i] == nums[i - 1]) 
	    		continue;
	    	int sum = target - nums[i];
	    	int j = i + 1;
	    	int k = end;
	    	while (j < k && j < end) {
	    		if (nums[j] + nums[k] == sum) {
	    			result.add(Arrays.asList(nums[i], nums[j], nums[k]));
	    			while (j < k && nums[j] == nums[j + 1]) j++;
	    			while (j < k && nums[k] == nums[k - 1]) k--;
	    			j++;
	    			k--;
	    		} else if (nums[j] + nums[k] < sum) {
	    			j++;
	    		} else {
	    			k--;
	    		}
	    	}
	    }
	    return result;
	}
	public static void main(String[] args) {
		int[] nums = {-498,-492,-473,-455,-441,-412,-390,-378,-365,-359,-358,-326,-311,-305,
				-277,-265,-264,-256,-254,-240,-237,-234,-222,-211,-203,-201,-187,-172,-164,-134,
				-131,-91,-84,-55,-54,-52,-50,-27,-23,-4,0,4,20,39,45,53,53,55,60,82,88,89,89,98,
				101,111,134,136,209,214,220,221,224,254,281,288,289,301,304,308,318,321,342,348,
				354,360,383,388,410,423,442,455,457,471,488,488};
		List<List<Integer>> result = fourSum(nums, 20);
		for (List<Integer> list: result) {
			for (Integer i: list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
