import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String> > map = new LinkedHashMap<String, List<String>>();
        for (String s: strs) {
        	char[] temp = s.toCharArray();
        	Arrays.sort(temp);
        	String str = new String(temp);
        	List<String> list;
        	if (map.containsKey(str)) {
        		list = map.get(str);
        	} else {
        		list = new ArrayList<String>();
        	}
        	list.add(s);
        	map.put(str, list);
        }
        for (String s: map.keySet()) {
        	List<String> temp = map.get(s);
        	Collections.sort(temp);
        	result.add(temp);
        }
        return result;
    }
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(strs);
		for (List<String> list: result) {
			for (String s: list) {
				System.out.print(s + " ");
			}
			System.out.println("");
		}
	}
}
