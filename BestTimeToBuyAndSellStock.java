
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {    
        if (prices.length == 0)
            return 0;
        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] > min){
                result = Math.max(result, prices[i] - min);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] prices = {5, 1, 2,7};
        System.out.println(maxProfit(prices));
    }
}
