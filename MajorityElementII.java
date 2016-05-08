import java.util.ArrayList;
import java.util.List;

/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月16日 下午8:25:23 
* 
*/
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int maj1 = 0;
        int maj2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (c1 == 0) {
                maj1 = nums[i];
                c1 = 1;
            } else if(maj1== nums[i]) {
                c1++;
            } else if(c2 == 0) {
                maj2= nums[i];
                c2= 1;
            } else if(maj2 == nums[i]) {
                c2++;
            } else {
                c1--;
                c2--;
            }   
        }   
        c1 = c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maj1 == nums[i]) {
                c1++;
            } else if (maj2 == nums[i]) {
                c2++;
            }   
        }   
        List<Integer> result = new ArrayList<Integer>();
        if (c1 > nums.length / 3) result.add(maj1);
        if (c2 > nums.length / 3) result.add(maj2);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5, 1};
        List<Integer> result = majorityElement(nums);
        for (Integer i: result) {
            System.out.println(i);
        }
    }
}
