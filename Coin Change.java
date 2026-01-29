// You are given an integer array coins 
// representing coins of different
// denominations and an integer amount
// representing a total amount of money.

// Return the fewest number of coins that
// you need to make up that amount. If that
// amount of money cannot be made up by any
// combination of the coins, return -1.

// You may assume that you have an infinite 
// number of each kind of coin.
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2^31 - 1
// 0 <= amount <= 10^4
import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        /**
         * dp[i] will store the minimum number of coins needed to make amount i.
         * We initialize the array with amount+1 because:
         *   - It's larger than any possible answer.
         *   - We can treat it as "infinity" when comparing minimums.
         */
        int[] dp = new int[amount + 1];

        // Fill dp[] with a large value representing impossible (infinity)
        Arrays.fill(dp, amount + 1);

        // Base case:
        // Minimum number of coins needed to form amount 0 is 0
        dp[0] = 0;

        /**
         * Build the solution from amount 1 up
          to the final 'amount'.
         * For each amount i, try every coin.
         * If the coin value is <= i, then:
         *   we check dp[i - coin] (the best
          solution to form the remaining amount).
         *   dp[i] becomes the minimum among all
          possibilities.
         */
        for (int i = 1; i <= amount; i++) {

            // Try taking each coin
            for (int coin : coins) {

                // Only valid if coin does not
                 exceed current amount
                if (i - coin >= 0) {

                    /**
                     * dp[i - coin] is the minimum 
                     coins needed to form the remaining amount.
                     * We add +1 because we use one coin (the current one).
                     * Then we minimize dp[i] with this value.
                     */
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        /**
         * If dp[amount] is still the "infinity"
          placeholder (amount + 1),
         * it means we never found a valid combination.
         */
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// Time: O(amount × coins)
// Space: O(amount)