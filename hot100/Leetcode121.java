package hot100;

public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
                continue;
            }
            res = Math.max(prices[i] - minValue, res);
        }
        return res;
    }
}
