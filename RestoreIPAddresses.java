import java.util.ArrayList;
import java.util.List;


public class RestoreIPAddresses {
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        restoreIpAddresses(s, 4, result, "");
        return result;
    }
	private static void restoreIpAddresses(String s, int n, List<String> result, String cur) {
		if (n == 0 && !s.equals("")) {
			return;
		}
		if (n == 1) {
			if (s.equals("") || s.length() > 3)
				return;
			if (s.length() >= 2 && s.charAt(0) == '0')
				return;
			int num = Integer.parseInt(s);
			if (0 <= num && num <= 255) {
				result.add(cur + s);
				return;
			}
		} else {
			for (int i = 1; i <= 3; i++) {
				if (s.length() <= i)
					continue;
				String temp = s.substring(0, i);
				if (temp.length() >= 2 && temp.charAt(0) == '0')
					continue;
				int num = Integer.parseInt(temp);
				if (0 <= num && num <= 255) {
					restoreIpAddresses(s.substring(i), n - 1, result, cur + temp + ".");
				}
			}
		}
	}
	public static void main(String[] args) {
		List<String> result = restoreIpAddresses("010010");
		for (String s: result) {
			System.out.println(s);
		}
	}
}
