
public class CountAndSay {
    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        while (n > 1) {
            String temp = sb.toString();
            sb = new StringBuilder();
            for (int i = 0; i < temp.length(); ) {
                char ch = temp.charAt(i);
                int count = 1;
                while (i + count < temp.length() && ch == temp.charAt(i + count))
                    count++;
                sb.append(String.valueOf(count));
                sb.append(ch);
                i += count;
            }    
            n--;
            
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        
    }
}
