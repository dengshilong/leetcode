
public class LargestRectangleinHistogram {
	public static int largestRectangleArea(int[] height) {
		/* use monotonous stack */
		if (height.length == 0)
			return 0;
        int[] stack = new int[height.length + 1];
        int top = 0;
        stack[top] = -1;
        int result = 0;
        for (int i = 0; i <= height.length; i++) {
        	int h;
        	if (i == height.length) {
        		h = -1;
        	} else {
        		h = height[i];
        	}
        	while (top != 0 && height[stack[top]] > h) {
        		int temp = height[stack[top]] * (i - 1 - stack[top - 1]);
        		if (temp > result) {
        			result = temp;
        		}
        		top--;
        	}
        	top++;
        	stack[top] = i;
        }
        return result;
    }
	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
		System.out.println(largestRectangleArea(new int[]{}));
		System.out.println(largestRectangleArea(new int[]{0}));
	}
}
