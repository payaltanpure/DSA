// 219. Contains Duplicate II
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1
// Output: true
// Example 3:

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         for(int i=0; i<nums.length;i++)
//         {
//             for(int j=i+1;j<nums.length;j++)
//             {
//                 if(nums[i]==nums[j] && Math.abs(i - j) <= k) 
//                 {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int previndex = map.get(nums[i]);

                if (i - previndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i); // put nums value as key in map and index as value in hashmap
        }
        return false;
    }
}

import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0; // manual index counter

        for (int num : nums) {

            // Check if current number already exists in map
            if (map.containsKey(num)) {
                int prevIndex = map.get(num);

                // Check distance between current index and previous index
                if (i - prevIndex <= k) {
                    return true;
                }
            }

            // Store/update current number with its latest index
            map.put(num, i);

            i++; // move to next index
        }

        return false;
    }
}