
public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int result = 0;
        int buy = prices[0];
        int sell = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= buy) {
                if (sell != buy) {
                    result += sell - buy;
                }
                buy = prices[i];
                sell = prices[i];
            } else {
                if (prices[i] > sell) {
                    sell = prices[i];
                } else {
                    result += sell - buy;
                    buy = prices[i];
                    sell = prices[i];
                }
            }
        }
        result += sell - buy;
        return result;
    }
    public static void main(String[] args) {
        int[] prices = {5, 7, 1, 2, 3, 1, 7};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
