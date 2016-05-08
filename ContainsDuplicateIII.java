import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0)
            return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        t++;
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                map.remove(getID(nums[i - k - 1], t));
            int m = getID(nums[i], t);
            if (map.containsKey(m)) 
                return true;
            if (map.containsKey(m - 1) && Math.abs(nums[i] - map.get(m - 1)) < t)
                    return true;
            if (map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m + 1)) < t)
                return true;
            map.put(m, nums[i]);        
        }
        return false;
    }
    public static int getID(int i, int t) {
        return i < 0 ? (i + 1) / t - 1 : i / t;
    }
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 2, 1));
    }
    
}
