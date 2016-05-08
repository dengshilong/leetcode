import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();     
        Map<String, Integer> strs = new HashMap<String, Integer>();
        for (String str: words) {
            if (!strs.containsKey(str)) {
                strs.put(str, 1);
            } else {
                strs.put(str, strs.get(str) + 1);
            }
        }
        int length = words[0].length();
        int totalLength = length * words.length;
        for (int i = 0; i <= s.length() - totalLength; i++) {
             Map<String, Integer> visited = new HashMap<String, Integer>(strs);
            int j = i;
            int count = 0;
            while (j <= s.length() - length) {
                String word = s.substring(j, j + length);
                if (!visited.containsKey(word))
                    break;
                int temp = visited.get(word) - 1;
                if (temp < 0)
                    break;
                visited.put(word, temp);
                count += 1;
                j += length;
            }
            if (count == words.length) {
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = new String[] {"word","good","best","good"};
        List<Integer> result = findSubstring("wordgoodgoodgoodbestword", words);
//        String[] words = new String[] {"foo","bar"};
//        List<Integer> result = findSubstring("barfoothefoobarman", words);
        for (Integer i: result) {
            System.out.println(i);
        }
    }
}
