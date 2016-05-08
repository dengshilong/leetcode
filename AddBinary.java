
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remain = 0;
        while (i >= 0 && j >= 0) {
            int s = (a.charAt(i) - '0') + (b.charAt(j) - '0') + remain;
            sb.append(s % 2);
            remain = s / 2;
            i--;
            j--;
        }
        while (i >= 0) {
            int s = (a.charAt(i) - '0') + remain;
            sb.append(s % 2);
            remain = s / 2;
            i--;
        }
        while (i >= 0) {
            int s = (b.charAt(j) - '0') + remain;
            sb.append(s % 2);
            remain = s / 2;
            j--;
        }
        if (remain > 0) {
            sb.append(remain);
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(addBinary("1101", "1111"));
    }
}
