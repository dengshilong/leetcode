
public class ValidAnagram {
    final static int NUM = 256;
    public static boolean isAnagram(String s, String t) {
        int[] count = new int[NUM];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]--;
        }
        int zeroNum = 0;
        for (int i = 0; i < NUM; i++) {
            if (count[i] == 0)
                zeroNum++;
        }
        return zeroNum == NUM;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
