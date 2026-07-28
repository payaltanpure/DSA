// 198. House Robber
// Medium
// Topics
// premium lock icon
// Companies
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.

// two options skip cuurent money so for that position we will take previous house money prev1 and 
// second option is rob current house so for that we will take money of current house and add it to prev2 which is money of house before previous house because we cannot rob adjacent houses so we will take max of both options and store it in current and then move the window forward by making prev2 = prev1 and prev1 = current and at the end return prev1 which will have maximum money that can be robbed

class Solution {
    public int rob(int[] nums) {

        // If there is only one house,
        // rob that house.
        if (nums.length == 1) {
            return nums[0];
        }

        // prev2 = Maximum money till house 0
        int prev2 = nums[0];

        // prev1 = Maximum money till house 1
        // We can rob either house 0 or house 1,
        // whichever has more money.
        int prev1 = Math.max(nums[0], nums[1]);

        // Start checking from house 2
        for (int i = 2; i < nums.length; i++) {

            // Option 1:
            // Skip the current house.
            // Profit remains the same as previous house.
            int skip = prev1;

            // Option 2:
            // Rob the current house.
            // Since adjacent houses can't be robbed,
            // add current money to profit till house (i-2).
            int rob = prev2 + nums[i];

            // Choose the better option.
            int current = Math.max(skip, rob);

            // Move the window one step forward.
            prev2 = prev1;
            prev1 = current;
        }

        // prev1 always stores the maximum profit
        // till the last house.
        return prev1;
    }
}

// Algorithm
// Step 1

// If there is only one house, rob it.

// Step 2

// Maintain two variables:

// prev2 → Maximum money till house i-2
// prev1 → Maximum money till house i-1
// Step 3

// For every new house:

// There are only 2 choices:

// Skip this house → Money = prev1
// Rob this house → Money = prev2 + nums[i]

// Choose the larger one.

// current = max(prev1, prev2 + nums[i])
// Step 4

// Move the window forward.

// prev2 = prev1
// prev1 = current
// Step 5

// After the loop, prev1 contains the maximum money.

// House: 0 1 2 3 4
// Money: 2 7 9 3 1
// ↑ ↑
// prev2 prev1

// -------------------------

// House 2

// Skip = 7
// Rob = 2 + 9 = 11

// Current = 11

// Move →

// prev2 = 7
// prev1 = 11

// -------------------------

// House 3

// Skip = 11
// Rob = 7 + 3 = 10

// Current = 11

// Move →

// prev2 = 11
// prev1 = 11

// -------------------------

// House 4

// Skip = 11
// Rob = 11 + 1 = 12

// Current = 12

// Move →

// prev2 = 11
// prev1 = 12