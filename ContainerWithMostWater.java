
public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
        	result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
        	if (height[left] < height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] height = {4,2,3,5,7,4,1};
		System.out.println(maxArea(height));
	}
}
