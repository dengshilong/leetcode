import java.util.ArrayList;


public class UglyNumberII {
	public static int nthUglyNumber(int n) {
		int[] nums = new int[n];
        int two = 0;
        int three = 0;
        int five = 0;
        int result = 1;
        nums[0] = 1;
        int length = 1;
        while (length < n) {
        	result = minOfThree(nums[two] * 2, nums[three] * 3, nums[five] * 5);
        	nums[length] = result;
        	if (result == nums[two] * 2) {
        		two++;
        	}
        	if (result == nums[three] * 3) {
        		three++;
        	}
        	if (result == nums[five] * 5) {
        		five++;
        	}  	     	
        	length++;
        }
        return result;
    }
//	public static int nthUglyNumber(int n) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//        int two = 0;
//        int three = 0;
//        int five = 0;
//        int result = 1;
//        list.add(1);
//        while (list.size() < n) {
//        	result = minOfThree(list.get(two) * 2, list.get(three) * 3, list.get(five) * 5);
//        	list.add(result);
//        	if (result == list.get(two) * 2) {
//        		two++;
//        	}
//        	if (result == list.get(three) * 3) {
//        		three++;
//        	}
//        	if (result == list.get(five) * 5) {
//        		five++;
//        	}  	     	
//        }
//        return result;
//    }
	public static int minOfThree(int a, int b, int c) {
		return a <= b ? (a <= c ? a : c) : (b <= c ? b : c);
	}
	public static void main(String[] args) {
		for (int i = 1; i <= 12; i++) {
			System.out.println(nthUglyNumber(i));
		}
		System.out.println(nthUglyNumber(11));
	}
}
