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

// # Understanding the DP Formula in Coin Change

// Let's focus on **only one line of code**, because this is where most people
// get confused.

// ```cpp
// dp[i] = min(dp[i], dp[i - coin] + 1);
// ```

// Forget the whole program for a moment. Assume:

// ```text
// coins = [1, 2, 5]
// amount = 5
// ```

// ## Example 1

// Suppose we are calculating:

// ```cpp
// i = 4;
// coin = 2;
// ```

// Now substitute these values into the formula:

// ```cpp
// dp[4] = min(dp[4], dp[4 - 2] + 1);
// ```

// Simplify it:

// ```cpp
// dp[4] = min(dp[4], dp[2] + 1);
// ```

// Now ask yourself:

// ### What does `dp[2]` mean?

// It means:

// > **The minimum number of coins required to make amount 2.**

// We already calculated it earlier.

// ```text
// dp[2] = 1
// ```

// because

// ```text
// 2 = 2
// ```

// Only one coin is needed.

// Now substitute this value into the formula:

// ```cpp
// dp[4] = min(dp[4], 1 + 1);
// ```

// ### Why do we add `+1`?

// Because:

// * `dp[2] = 1` means **1 coin is needed to make the remaining amount (2)**.
// * We are **also using the current coin (2)**.

// So,

// ```text
// Remaining amount (2) → 1 coin
// Current coin (2) → 1 coin
// ------------------------------
// Total → 2 coins
// ```

// Therefore,

// ```cpp
// dp[4] = min(dp[4], 2);
// ```

// ---

// ## Example 2

// Suppose

// ```cpp
// i = 5;
// coin = 1;
// ```

// The formula becomes

// ```cpp
// dp[5] = min(dp[5], dp[4] + 1);
// ```

// What is `dp[4]`?

// ```text
// dp[4] = 2
// ```

// because

// ```text
// 4 = 2 + 2
// ```

// needs 2 coins.

// Now we use one more coin (1).

// ```text
// 4 needs 2 coins

// +

// Current coin (1)

// =

// 3 coins
// ```

// So,

// ```cpp
// dp[5] = min(dp[5], 3);
// ```

// ---

// ## Example 3

// Suppose

// ```cpp
// i = 5;
// coin = 5;
// ```

// The formula becomes

// ```cpp
// dp[5] = min(dp[5], dp[0] + 1);
// ```

// Why `dp[0]`?

// Because

// ```text
// Remaining amount

// 5 - 5 = 0
// ```

// How many coins are needed to make amount 0?

// ```text
// 0
// ```

// Now add the current coin.

// ```text
// Remaining amount = 0 coins

// +

// Current coin = 1 coin

// =

// 1 coin
// ```

// So,

// ```cpp
// dp[5] = min(dp[5], 1);
// ```

// Now `dp[5]` becomes **1**.

// ---

// # Think of It Like Paying a Bill

// Suppose your bill is **₹11**.

// You have coins of **₹1, ₹2, and ₹5**.

// You decide to use a **₹5 coin first**.

// After using it:

// ```text
// ₹11

// ↓

// Use ₹5

// ↓

// Still need ₹6
// ```

// Now imagine your friend already tells you:

// > "I already know the minimum number of coins required to make ₹6."

// That answer is stored in

// ```cpp
// dp[6]
// ```

// Suppose

// ```text
// dp[6] = 2
// ```

// That means

// ```text
// ₹6 can be made using 2 coins.
// ```

// But remember, **you have already used one ₹5 coin**.

// So the total coins become

// ```text
// Current ₹5 coin = 1

// +

// Coins needed for ₹6 = 2

// =

// 3 coins
// ```

// That's exactly why the code does:

// ```cpp
// dp[11] = dp[6] + 1;
// ```

// The `+1` is **not magic**.

// It simply counts **the current coin that you just decided to use**.

// ---

// # Translate the Formula into English

// ### `dp[i - coin]`

// ➡️ "The minimum number of coins required to make the **remaining amount**."

// ### `+1`

// ➡️ "Count the **current coin** that I just picked."

// ### `min(...)`

// ➡️ "Among all possible first coins (1, 2, or 5), choose the option that uses
// the **fewest total coins**."

// ---

// # One Sentence to Memorize

// Whenever you see

// ```cpp
dp[i]=

min(dp[i], dp[i - coin] + 1);
```

Read it as:

> **"If I choose this coin first, then I need 1 coin (the current one) plus the minimum number of coins required for the remaining amount (`i - coin`). If this gives a better answer than what I have so far, update `dp[i]`."**

Once this sentence makes sense, the entire Coin Change DP solution becomes much easier to understand.
