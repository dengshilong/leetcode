
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }
}
