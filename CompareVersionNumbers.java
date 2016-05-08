import java.util.Arrays;


public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] as = version1.split("\\.");
        String[] bs = version2.split("\\.");
        int i;
        for (i = 0; i < as.length && i < bs.length; i++) {
            int a = Integer.parseInt(as[i]);
            int b = Integer.parseInt(bs[i]);
            if (a == b) {
                continue;
            } else if (a < b) {
                return -1;
            } else {
                return 1;
            }
        }
        if (as.length < bs.length) {
            for (; i < bs.length; i++) {
                if (Integer.parseInt(bs[i]) != 0) {
                    return -1;
                }
            }
            return 0;
        } else if (as.length > bs.length){
            for (; i < as.length; i++) {
                if (Integer.parseInt(as[i]) != 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println(compareVersion("1.1", "2.1"));
        System.out.println(compareVersion("1.1", "1.1.0.0"));
        
        
    }
}
