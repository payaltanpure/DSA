// 15. 3Sum
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.
// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        int sum = 0;

        List<List<Integer>> threeSum = new ArrayList<>(); // added result list

        Arrays.sort(nums); // required for two pointer

        for (int i = 0; i < n - 2; i++) {
            // a = nums for understanding
            if (i > 0 && nums[i] == nums[i - 1]) // used to select the a[i]/ nums[i]
            {
                continue;
            }

            int left = i + 1; // select left and right in remaining array in every iteration of two sum
            int right = n - 1;

            sum = -1 * nums[i]; // select a[i](-1*a[i])in every iteration of two sum

            // two sum logic
            while (left < right) {
                int s = nums[left] + nums[right];

                if (sum == s) {
                    // adding triplet
                    threeSum.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // duplicate condition
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (s < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return threeSum; // return triplet
    }
}