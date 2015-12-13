
public class AddDigits {
	public static int addDigits(int num) {
        if (num <= 9) {
            return num;
        } else {
            int res = num % 9;
            if (res == 0) {
                return 9;
            } else {
                return res;
            }
        }   
	}
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++)
			System.out.println(addDigits(i));
	}
}
