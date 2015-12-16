
public class HIndexII {
	public static int hIndex(int[] citations) {
		int result = 0;
		int left = 0;
		int right = citations.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (citations[mid] >= citations.length - mid) {
				result = Math.max(result, citations.length - mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
    }
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(hIndex(citations));
		System.out.println(hIndex(new int[]{1, 2, 3, 100}));
		System.out.println(hIndex(new int[]{0}));
	}
}
