// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        // dp[i] = minimum coins needed to make amount i
        vector<int> dp(amount + 1, amount + 1);

        // Base case
        dp[0] = 0;

        // Calculate answer for every amount from 1 to amount
        for (int i = 1; i <= amount; i++) {

            // Try every coin
            for (int coin : coins) {

                // If this coin can be used
                if (coin <= i) {

                    dp[i] = min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If amount cannot be formed
        if (dp[amount] > amount)
            return -1;

        return dp[amount];
    }
};



// https://chatgpt.com/c/6a7327af-28a8-83e8-9206-9f72bcaf7b6b