// 283. Move Zeroes
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

class Solution {
    public void moveZeroes(int[] nums) {

        int j = 0; // to track position of non zero elements and non zero elements using j from
                   // starting 0

        // Move all non-zero elements to front
        for (int i = 0; i < nums.length; i++) // i is used to traverse the array
        {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Fill the remaining positions with 0
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }

    }
}

// ex: [0,1,0,3,12]
// ans: [1,3,12,0,0]