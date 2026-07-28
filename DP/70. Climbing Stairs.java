// 70. Climbing Stairs
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

class Solution {
    public int climbStairs(int n) {

        // If there is only 1 or 2 steps,
        // the answer is the same as n.
        // n = 1 -> 1 way
        // n = 2 -> 2 ways
        if (n <= 2) {
            return n;
        }

        // first stores the number of ways to reach step 1
        int first = 1;

        // second stores the number of ways to reach step 2
        int second = 2;

        // Start calculating from step 3 up to step n
        for (int i = 3; i <= n; i++) {

            // Number of ways to reach the current step
            // = ways to reach previous step
            // + ways to reach two steps before
            int current = first + second;

            // Move the window one step forward

            // first now becomes the old second
            // (ways to reach previous step)
            first = second;

            // second now becomes the newly calculated answer
            // (ways to reach current step)
            second = current;
        }

        // After the loop,
        // second contains the number of ways to reach step n
        return second;
    }
}

// second stores the current which is our answer so return second

// it act as fibonacci series
// n 1 2 3 4 5 6 7
// ways 1 2 3 5 8 13 21
// so spplied fibonacci series logic