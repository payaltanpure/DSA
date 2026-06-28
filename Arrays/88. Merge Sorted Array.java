// ou are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

// Example 1:

// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Example 2:

// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].
// Example 3:

// Input: nums1 = [0], m = 0, nums2 = [1], n = 1
// Output: [1]
// Explanation: The arrays we are merging are [] and [1].
// The result of the merge is [1].
// Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}



// Let's trace your Java code step by step for:

// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3

// Goal:

// [1,2,2,3,5,6]
// Initial Pointers
// i = m - 1 = 2
// j = n - 1 = 2
// k = m + n - 1 = 5

// Meaning:

// i → last valid element in nums1
// j → last element in nums2
// k → last position to fill in nums1
// Initial State
// nums1 = [1,2,3,0,0,0]
//              i     k

// nums2 = [2,5,6]
//              j

// Values:

// nums1[i] = 3
// nums2[j] = 6
// Iteration 1

// Compare:

// 3 > 6 ? false

// So:

// nums1[k] = nums2[j]
// nums1[5] = 6

// Array becomes:

// [1,2,3,0,0,6]

// Move:

// j = 1
// k = 4
// Iteration 2

// Now:

// nums1[i] = 3
// nums2[j] = 5

// Compare:

// 3 > 5 ? false

// So:

// nums1[4] = 5

// Array:

// [1,2,3,0,5,6]

// Move:

// j = 0
// k = 3
// Iteration 3

// Now:

// nums1[i] = 3
// nums2[j] = 2

// Compare:

// 3 > 2 ? true

// So:

// nums1[3] = 3

// Array:

// [1,2,3,3,5,6]

// Move:

// i = 1
// k = 2
// Iteration 4

// Now:

// nums1[i] = 2
// nums2[j] = 2

// Compare:

// 2 > 2 ? false

// So take from nums2:

// nums1[2] = 2

// Array:

// [1,2,2,3,5,6]

// Move:

// j = -1
// k = 1
// Main Loop Ends

// Condition:

// while(i >= 0 && j >= 0)

// Now j = -1, so stop.

// Remaining nums2?
// while(j >= 0)

// False, so skip.

// Final Answer
// [1,2,2,3,5,6]