// You are given an integer array prices where
// prices[i] is the price of a given stock
// on the ith day, and an integer k.
// Find the maximum profit you can achieve.
// You may complete at most k transactions:
// i.e. you may buy at most k times and sell
// at most k times.
// Note: You may not engage in multiple
// transactions simultaneously (i.e., you 
// must sell the stock before you buy again).

// 1 <= k <= 100
// 1 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n == 0) return 0; // empty prices → no profit
    // Edge case: unlimited transactions allowed
    // If k >= n/2, we can just do as many transactions as we want
    if (k >= n / 2) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) 
                profit += prices[i] - prices[i - 1]; // buy yesterday, sell today
        }
        return profit;
    }
    // dp[j] = max profit up to current day with at most j transactions
    int[] dp = new int[k + 1];
    // maxDiff[j] = max(dp[j-1] - prices[i]) so far → best "buy day" for transaction j
    int[] maxDiff = new int[k + 1];
    // Initialize maxDiff for each transaction with -prices[0] (buy on day 0)
    for (int j = 0; j <= k; j++) maxDiff[j] = -prices[0];
    // Iterate over each day
    for (int i = 1; i < n; i++) {
        // Iterate over number of transactions from 1 to k
        for (int j = 1; j <= k; j++) {
            // Either do nothing today (dp[j]) or sell today (prices[i] + maxDiff[j])
            dp[j] = Math.max(dp[j], prices[i] + maxDiff[j]);
            // Update maxDiff[j]: best "buy" for next day
            // Either keep previous maxDiff[j], or buy today after j-1 transactions
            maxDiff[j] = Math.max(maxDiff[j], dp[j - 1] - prices[i]);
        }
    }
    // Max profit with at most k transactions
    return dp[k];
}

// Time: O(n * k)
// Space: O(k)
