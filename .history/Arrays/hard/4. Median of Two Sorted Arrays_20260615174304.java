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
 

// Approach 1: Merge Both Arrays and Find Median

// This is the easiest approach to understand.

// Idea
// Merge the two sorted arrays into one sorted array.
// Find the total number of elements.
// If total elements are odd:
// Median = middle element.
// If total elements are even:
// Median = average of the two middle elements.


// Example 1 (Odd Length)
// Input
// nums1 = [1,3]
// nums2 = [2]
// Merge Process

// Initial:

// i=0 j=0

// nums1[i]=1
// nums2[j]=2

// Since:

// 1 < 2

// Put 1

// merged = [1]

// Now:

// i=1

// nums1[i]=3
// nums2[j]=2

// Since:

// 2 < 3

// Put 2

// merged = [1,2]

// Copy remaining:

// merged = [1,2,3]
// Find Median

// Length:

// n = 3

// Odd:

// median = merged[3/2]

//        = merged[1]

//        = 2

// Output:

// 2.0
// Example 2 (Even Length)
// Input
// nums1 = [1,2]
// nums2 = [3,4]
// Merge
// merged = [1,2,3,4]
// Find Median

// Length:

// n = 4

// Even:

// Middle indices:

// n/2     = 2
// n/2 -1  = 1

// Values:

// merged[1] = 2
// merged[2] = 3

// Median:

// (2+3)/2

// = 2.5

// Output:

// 2.5
// Dry Run Table

// For:

// nums1=[1,2]
// nums2=[3,4]
// Step	Action	Merged
// 1	Take 1	[1]
// 2	Take 2	[1,2]
// 3	Take 3	[1,2,3]
// 4	Take 4

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

Operation	Complexity
Merge arrays	O(n1 + n2)
Find median	O(1)
Total Time	O(n1 + n2)
Space	O(n1 + n2)




// optimal solution pending