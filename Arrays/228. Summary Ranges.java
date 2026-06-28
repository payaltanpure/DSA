// 228. Summary Ranges
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// You are given a sorted unique integer array nums.

// A range [a,b] is the set of all integers from a to b (inclusive).

// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

// Each range [a,b] in the list should be output as:

// "a->b" if a != b
// "a" if a == b
 

// Example 1:

// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"
// Example 2:

// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"



class Solution {
    public List<String> summaryRanges(int[] nums) {
        //         Meaning of “Consecutive”

        // Two numbers are consecutive if:

        // current = previous + 1

        // Examples:

        // 2 and 3 → consecutive
        // 3 and 4 → consecutive
        // 4 and 6 → not consecutive
        // Visual Representation

        // For:

        // nums = [0,1,2,4,5,7]
        // 0 — 1 — 2    4 — 5    7
        // |_______|    |___|    |
        // 0->2       4->5      7


       List<String> result = new ArrayList<>();

        // If array is empty, return empty list
        if (nums.length == 0) {
            return result;
        }

        // Start of current range
        int start = nums[0];

        // Traverse till nums.length (not nums.length - 1)
        // so that the last range is also processed
        for (int i = 1; i <= nums.length; i++) {

            // If:
            // 1. We reached the end of array, OR
            // 2. Current number is not consecutive
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {

                // End of current range
                int end = nums[i - 1];

                // If only one element in range
                if (start == end) {
                    result.add(String.valueOf(start));
                }
                // If multiple elements in range
                else {
                    result.add(start + "->" + end);
                }

                // Start next range if elements remain
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }
}