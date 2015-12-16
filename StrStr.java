import java.util.Arrays;


public class StrStr {
//	public static int strStr(String haystack, String needle) {
//        if (needle.length() == 0) {
//        	return 0;
//        }
//        int m = haystack.length();
//        int n = needle.length();
//        for (int i = 0; i < m - n + 1; i++) {
//        	boolean exist = true;
//        	for (int j = 0; j < n; j++) {
//        		if (haystack.charAt(i + j) != needle.charAt(j)) {
//        			exist = false;
//        			break;
//        		}
//        	}
//        	if (exist) {
//        		return i;
//        	}
//        }
//        return -1;
//    }
	public static int strStr(String str, String s) {
		int[] jump = getJump(s);
		int i = s.length() - 1;
		while (i < str.length()) {
			int j = s.length() - 1;
			int k = i;
			while (j >= 0) {
				if (str.charAt(k) != s.charAt(j)) {
					break;
				} else {
					k--;
					j--;
				}
			}
			if (j < 0) {
				return k + 1;
			} else {
				i += jump[str.charAt(i)];
			}
		}
		return -1;
	}
	public static int[] getJump(String s) {
		int[] jump = new int[256];
		Arrays.fill(jump, s.length());
		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			jump[ch] -= i + 1;
		}
		return jump;
	}
	public static int KMP(String str, String s) {
		if (str.equals("") && s.equals(""))
			return 0;
		int next[] = getNext(s);
		//System.out.println(Arrays.toString(next));
		int i = 0;
		int j = 0;
		while (i < str.length() && j < s.length()) {
		
			if (str.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else {
				if (j > 0) {
					j = next[j - 1] + 1;
				} else {
					i++;
				}
			}

		}
		return j >= s.length() ? i - s.length() : -1;
	}
	public static int[] getNext(String s) {
		if (s.equals("")) {
			return new int[0];
		}
		int[] next = new int[s.length()];
		next[0] = -1;
		for (int i = 1; i < s.length(); i++) {
			int j;
			for (j = next[i - 1]; j >= 0 && s.charAt(j + 1) != s.charAt(i); ) {
				j = next[j];
			}
			next[i] = (j < 0 && s.charAt(j + 1) != s.charAt(i)) ? -1 : j + 1;				
		}
		return next;
	}
	public static void main(String[] args) {
		System.out.println(strStr("abcd", "bc"));
		System.out.println(strStr("aaa", "bbb"));
		System.out.println(strStr("aaaa", "bba"));
		System.out.println(KMP("abcd", "bc"));
		System.out.println(KMP("aaa", "bbb"));
		System.out.println(KMP("aaaa", "bba"));
		System.out.println(KMP("aaabbbb", "bbbb"));
		System.out.println(KMP("aaabababa", "babab"));
		System.out.println(KMP("", ""));
		System.out.println(KMP("mississippi", "issip"));
				
	}
}
