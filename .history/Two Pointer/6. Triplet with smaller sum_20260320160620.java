// Triplets with Smaller Sum
// Given an array arr[] of distinct integers of size n and a value sum, the task is to find the count of triplets (i, j, k), having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.
// Examples :
// Input: n = 4, sum = 2, arr[] = {-2, 0, 1, 3}
// Output:  2
// Explanation: Below are triplets with sum less than 2 (-2, 0, 1) and (-2, 0, 3). 
// Input: n = 5, sum = 12, arr[] = {5, 1, 3, 4, 7}
// Output: 4
// Explanation: Below are triplets with sum less than 12 (1, 3, 4), (5, 1, 3), (1, 3, 7) and (5, 1, 4).

// User function Template for Java
import java.util.*;

class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            //set i 
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long currsum = arr[i] + arr[left] + arr[right];
                if (currsum < sum) {
                    count += (right - left);
                    left++;
                } else // if currsum>sum
                {
                    right--;
                }
            }
        }
        return count;
    }
}
