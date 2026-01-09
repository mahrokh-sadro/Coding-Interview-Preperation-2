// You are given an array prices where prices[i]
// is the price of a given stock on the ith day.
// You want to maximize your profit by choosing
// a single day to buy one stock and choosing
// a different day in the future to sell that stock.
// Return the maximum profit you can achieve
// from this transaction. If you cannot
// achieve any profit, return 0.
// 1 <= prices.length <= 10^5
// 0 <= prices[i] <= 10^4

public int maxProfit(int[] prices) {
    int maxProfit=0;
    int minPrice=prices[0];
    for(int i=1;i<prices.length;i++){
        minPrice=Math.min(minPrice,prices[i]);
        maxProfit=Math.max(maxProfit,prices[i]-minPrice);//future days’ impact
    }
    return maxProfit;
}
// Time: O(n) 
// Space: O(1)
