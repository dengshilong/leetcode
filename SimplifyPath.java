import java.util.ArrayList;
import java.util.List;


public class SimplifyPath {
	
	public static String simplifyPath(String path) {
        List<String> list = new ArrayList<String>();
        String[] dirs = path.split("/");
        
        for (String s: dirs) {
        	if (s.equals(".") || s.equals("")) {
        		continue;
        	} else if (s.equals("..") ) {
        		if (list.size() > 0) {
        			list.remove(list.size() - 1);		
        		}
        	} else {
        		list.add(s);
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (String s: list) {
        	sb.append("/");
        	sb.append(s);
        }
        if (sb.length() == 0) {
        	return "/";
        } else {
        	return sb.toString();
        }                
    }
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("./"));
		System.out.println(simplifyPath("/.."));
	}
}
