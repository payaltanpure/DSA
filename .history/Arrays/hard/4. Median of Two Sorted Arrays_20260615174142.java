// 4. Median of Two Sorted Arrays
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1  = nums1.length;
        int n2 = nums2.length;

        // merging array logic
        int[] merged = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while(i < n1 && j < n2) {
            if(nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while(i < n1) {
            merged[k++] = nums1[i++];
        }

        while(j < n2) {
            merged[k++] = nums2[j++];
        }

        int n = merged.length;

        if(n % 2 == 0) {
            return (merged[n/2] + merged[n/2 - 1]) / 2.0;
        } else {
            return merged[n/2];
        }
    }
}




// optimal solution pending