
public class ReverseInteger {
    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = Math.abs(x); 
        }   
        int max = Integer.MAX_VALUE / 10;
        int result = 0;
        while(x > 0) {
             if (result > max) {// overflow
                 return 0;
             }  
            result = result * 10 + x % 10; 
            x = x / 10; 
        }   
        if (flag) {
            result = -result;
        }   
        return result;
    }
    public static void main(String[] args) {
        System.out.println(reverse(-1));
        System.out.println(reverse(-24567));
    }
}
