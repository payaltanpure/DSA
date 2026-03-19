// 16. 3Sum Closest
// Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int n = nums.length;
        int sum = 0, res_sum = 0;
        int max_diff = Integer.MAX_VALUE; // fixed

        Arrays.sort(nums); // required for two pointer

        for(int i = 0; i < n - 2; i++)
        {
            //a = nums for understanding
            if(i > 0 && nums[i] == nums[i - 1]) //used to select the a[i]/ nums[i]
            {
                continue;
            }

            int left = i + 1; //select left and right in remaining array in every iteration of two sum 
            int right = n - 1;

            while(left < right)
            {
                //total sum of triplet
                sum = nums[i] + nums[left] + nums[right];

                //find difference from target
                int diff = Math.abs(sum - target);

                //update closest sum
                if(diff < max_diff)
                {
                    max_diff = diff;
                    res_sum = sum;
                }

                // move pointers
                if(sum < target)
                {
                    left++;
                }
                else if(sum > target)
                {
                    right--;
                }
                else
                {
                    return sum; // exact match
                }
            }
        }

        return res_sum; //return sum of triplet closest to target
    }
}