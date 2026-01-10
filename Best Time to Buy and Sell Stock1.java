// You are given an array prices where prices[i] 
// is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You
// may complete as many transactions as you like
// (i.e., buy one and sell one share of the
// stock multiple times) with the following restrictions:
// After you sell your stock, you cannot buy
// stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the 
// stock before you buy again).
// 1 <= prices.length <= 5000
// 0 <= prices[i] <= 1000
public int maxProfit(int[] prices) {
    // buy  = max profit while HOLDING a stock
    // sell = max profit while NOT holding a stock
    int buy = Integer.MIN_VALUE;
    int sell = 0;
    // Previous states (used to control transitions)
    int pre_buy = 0;
    int pre_sell = 0;
    for (int price : prices) {
        // Save previous buy state
        pre_buy = buy;
        // Buy today or keep holding
        // Uses pre_sell from TWO days ago → enforces cooldown
        buy = Math.max(pre_buy, pre_sell - price);
        // Save previous sell state
        pre_sell = sell;
        // Sell today or keep resting
        sell = Math.max(pre_sell, pre_buy + price);
    }
    // Best profit must end without holding stock
    return sell;
}

// Time: O(n)
// Space: O(1)
