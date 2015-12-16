
public class Candy {
	public static int candy(int[] ratings) {
        int cur = 1;
        int index = 0;
        int result = 1;
        for (int i = 1; i < ratings.length; i++) {
        	if (ratings[i] == ratings[i - 1]) {
        		cur = 1;
        		result += cur;
        		index = i;
        	} else if (ratings[i] > ratings[i - 1]) {
        		cur++;
        		result += cur;
        		index = i;
        	} else {
        		while (i < ratings.length && ratings[i] < ratings[i - 1]) {
        			i++;
        		}
        		i--;
        		int start = 0;
        		int j;
        		for (j = i; j > index; j--) {
        			start += 1;
        			result += start;
        		}
        		if (start >= cur) {
        			result += start > cur ? start - cur + 1: 1;
        		}
        		cur = 1;	
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println(candy(new int[]{3,2,1}));
		System.out.println(candy(new int[]{3,2,1,2,3,2,2}));
	}
}
