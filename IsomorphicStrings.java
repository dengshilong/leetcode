import java.util.HashMap;
import java.util.Map;


public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Map<String, String> map = new HashMap<String, String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(String.valueOf(s.charAt(i)))) {
                if (map.containsValue(String.valueOf(t.charAt(i))))
                    return false;
                map.put(String.valueOf(s.charAt(i)), String.valueOf(t.charAt(i)));
            }
            sb.append(map.get(String.valueOf(s.charAt(i))));
        }
        String res = sb.toString();
        //System.out.println(res);
        return res.equals(t);
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "abb"));
        System.out.println(isIsomorphic("egg", "abc"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
