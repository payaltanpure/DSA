// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.
// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

//Brute Force Approach
//time comp: O(n2)
//space comp: O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}

// optinmal approach but only applicable on sorted array
// time comp: O(n)
// space : O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = n - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == target) {
                return new int[] { i, j };
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] { -1, -1 };
    }
}

// best optimal approach
// time : O(n)
// space: O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int need= target-nums[i];
            if (map.containsKey(need))
            {
                return new int[]{map.get(need),i};  //get index of need from hashmap returing it and i means index of current element of array num[i]
            }

            map.put(nums[i],i);  //array element as key and its index as value of key in hashmap
        }
        return new int[]{-1, -1};
    }
}

// Main Idea

// For every current number:

// nums[i]

// We calculate what number is needed to complete the target:

// need=target−nums[i]

// Then ask:

// Have I already seen this needed number before?

// If yes → pair found
// If no → store current number and move ahead
// Why This Works

// If target = 9

// and current number = 7

// Then:

// need=9−7=2

// So if 2 appeared earlier, then:

// 2+7=9

// Answer found.

// Step-by-Step Example
// nums = [2,7,11,15]
// target = 9
// First Number = 2

// Need:

// 9−2=7

// 7 not seen yet.

// Store 2.

// Next Number = 7

// Need:

// 9−7=2

// 2 already stored.

// So pair is:

// [0,1]
