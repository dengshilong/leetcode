import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals(""))
            return 0;
        int result = 1;
        int length = 1;
        int start = 0;
        int[] positions = new int[256];
        Arrays.fill(positions, -1);
        positions[s.charAt(0)] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (positions[s.charAt(i)] != -1) {
                int temp = positions[s.charAt(i)];
                positions[s.charAt(i)] = i;
                if (temp < start) {
                    length++;
                } else {
                    result = Math.max(result, length);
                    start = temp + 1;    
                    length = i - start + 1;
                }
            } else {
                length++;
                positions[s.charAt(i)] = i;
            }
        }
        result = Math.max(result, length);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
