
class Solution {

    static int solve(int[] prices, int index, int minPrice) {

        // Base case
        if (index == prices.length) {
            return 0;
        }

        // Aaj tak ka minimum buying price
        minPrice = Math.min(minPrice, prices[index]);

        // Aaj sell karne par profit
        int profit = prices[index] - minPrice;

        // Aage ke days ka answer
        int nextProfit = solve(prices, index + 1, minPrice);

        return Math.max(profit, nextProfit);
    }

    public int maxProfit(int[] prices) {
        return solve(prices, 0, prices[0]);
    }
}
