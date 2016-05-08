/** 
* @author: robinjia
* @emai: dengshilong1988@gmail.com
* @create：2015年12月14日 下午10:53:53 
* 
*/
import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {
    private static String[][] refer={{},{},{"a","c","b"},{"d","e","f"},
            {"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},
            {"t","u","v"},{"w","x","y","z"}};
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0)
            return result;
        result = letterCombination(0, digits);
        return result;
    }
    private static List<String> letterCombination(int start, String digits) {
        List<String> result = new ArrayList<String>();
        if (start == digits.length()) {
            result.add("");
            return result;
        }
        List<String> temp = letterCombination(start + 1, digits);
        int index = digits.charAt(start) - '0';
        for (String first: refer[index]) {
            for (String second: temp) {
                result.add(first + second);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        for(String s: result) {
            System.out.println(s);
        }
    }
}

