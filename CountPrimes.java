
public class CountPrimes {
	public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
        	isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
        	if (isPrime[i]) {
        		for (int j = i + i; j < n;) {
        			isPrime[j] = false;
        			j += i;
        		}
        	}
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
        	if (isPrime[i]) {
        		count++;
        	}
        }
        return count; 
    }
	public static void main(String[] args) {
		System.out.println(countPrimes(20));
	}
}
