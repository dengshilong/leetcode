import java.util.HashMap;
import java.util.Map;


public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        if (pattern.equals("") || str.equals("")) {
            return false;
        }
        Map<String, String> map = new HashMap<String, String>();
        String[] words = str.split(" ");
        int i;
        for (i = 0; i < words.length && i < pattern.length(); i++) {
            if (!map.containsKey(words[i])) {
                if (map.containsValue(String.valueOf(pattern.charAt(i)))) {
                    return false;
                } else {
                    map.put(words[i], String.valueOf(pattern.charAt(i)));
                }
            }  else {
                String value = map.get(words[i]);
                if (!value.equals(String.valueOf(pattern.charAt(i)))) {
                    return false;
                }
            }
        }
        return i == words.length && i == pattern.length();
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("dog", "dog"));
    }
}
