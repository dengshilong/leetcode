
public class BestTimeToBuyAndSellStockIII {
	public static int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int result = 0;
		for (int i = 0; i < prices.length; i++) {
			int left = maxProfit(prices, 0, i - 1);
			int right = maxProfit(prices, i, prices.length - 1);
			result = Math.max(result, left + right);
		}
		return result;
    }
	private static int maxProfit(int[] prices, int start, int end) {	
		if (start >= end)
			return 0;
		int result = 0;
		int min = prices[start];
		for (int i = start + 1; i <= end; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else if (prices[i] > min){
				result = Math.max(result, prices[i] - min);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] prices = {5, 8, 1, 2, 3, 1, 7};
		//System.out.println(maxProfit(prices));
		System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
	}
}
