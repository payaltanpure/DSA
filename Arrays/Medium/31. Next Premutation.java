// Important Observation

// To get the next permutation:

// Start from the right side
// Find the first smaller element
// Swap it with the next greater element
// Reverse the remaining right part

// This gives the next immediate greater arrangement, not just any bigger arrangement.



// Understanding Examples
// Example 1

// Input:

// [1,2,3]

// Possible permutations in order:

// [1,2,3]
// [1,3,2]
// [2,1,3]
// [2,3,1]
// [3,1,2]
// [3,2,1]

// The next one after [1,2,3] is:

// [1,3,2]

// Output:

// [1,3,2]
// Example 2

// Input:

// [3,2,1]

// This is already the largest permutation.

// No bigger arrangement exists.

// So we return the smallest arrangement by sorting ascending:

// [1,2,3]
// Example 3

// Input:

// [1,1,5]

// Permutations in order:

// [1,1,5]
// [1,5,1]
// [5,1,1]

// Next permutation after [1,1,5] is:

// [1,5,1]
class Solution {
    public void nextPermutation(int[] nums) {
        //find smallest element from right side adjacent that is pivot
        // Pivot means: first number from right side which is smaller than its next number.
        //then comapre that pivot with right side element swap that right side ele with pivot which right side ele is greater that pivot
        // after swapping , that pivot and greater ele , reverse remaining right side array to get immediate bigger combinations not max greater no


        int n = nums.length;

        // Step 1: Find pivot
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If pivot found, find bigger number from right
        if (i >= 0) {
            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap pivot and bigger number
            swap(nums, i, j);
        }

        // Step 4: Reverse right side
        reverse(nums, i + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
    


    // Code meaning
// public void nextPermutation(int[] nums)

// This function changes the given array itself. It does not return anything.

// Example:

// nums = [1,2,3]

// After function:

// nums = [1,3,2]
// Step 1: Store length
// int n = nums.length;

// If array is:

// [1,2,3]

// Then:

// n = 3
// Step 2: Start checking from second last index
// int i = n - 2;

// Why n - 2?

// Because we compare:

// nums[i] >= nums[i + 1]

// So i + 1 must exist.

// For [1,2,3]:

// n = 3
// i = 1

// Index:

// index:  0  1  2
// nums:  [1, 2, 3]
//           i
// Step 3: Find pivot
// while (i >= 0 && nums[i] >= nums[i + 1]) {
//     i--;
// }

// Pivot means: first number from right side which is smaller than its next number.

// Example:

// [1,2,3]

// Check:

// nums[1] >= nums[2]
// 2 >= 3 false

// So loop stops.

// Pivot is:

// nums[i] = 2

// Because 2 < 3.

// Step 4: If pivot exists
// if (i >= 0) {

// If i >= 0, it means we found a pivot.

// If array is:

// [3,2,1]

// No pivot exists because all numbers are decreasing.

// Then i becomes -1.

// Step 5: Start j from last index
// int j = n - 1;

// For [1,2,3]:

// j = 2
// nums[j] = 3
// Step 6: Find number bigger than pivot
// while (nums[j] <= nums[i]) {
//     j--;
// }

// We need a number greater than pivot.

// Pivot is:

// nums[i] = 2

// Check from right:

// nums[j] = 3
// 3 <= 2 false

// So j stays at index 2.

// Step 7: Swap pivot and bigger number
// swap(nums, i, j);

// Before swap:

// [1,2,3]
//    ↑ ↑
//    i j

// Actually:

// i = 1, nums[i] = 2
// j = 2, nums[j] = 3

// After swap:

// [1,3,2]
// Step 8: Reverse right side
// reverse(nums, i + 1, n - 1);

// After pivot index, reverse remaining part.

// For [1,3,2]:

// i = 1
// i + 1 = 2
// n - 1 = 2

// Only one element:

// [2]

// So no change.

// Final answer:

// [1,3,2]
// swap function
// public void swap(int[] nums, int i, int j) {
//     int temp = nums[i];
//     nums[i] = nums[j];
//     nums[j] = temp;
// }

// Example:

// nums = [1,2,3]
// i = 1
// j = 2
// temp = nums[i];   // temp = 2
// nums[i] = nums[j]; // nums[1] = 3
// nums[j] = temp;   // nums[2] = 2

// Now:

// [1,3,2]
// reverse function
// public void reverse(int[] nums, int left, int right) {
//     while (left < right) {
//         swap(nums, left, right);
//         left++;
//         right--;
//     }
// }

// It reverses part of array.

// Example:

// nums = [1,4,5,3,2]
// left = 2
// right = 4

// Part to reverse:

// [5,3,2]

// After reverse:

// [2,3,5]

// Final:

// [1,4,2,3,5]
// Full dry run

// Input:

// [1,3,5,4,2]

// Find pivot:

// i = 3: nums[3] >= nums[4] → 4 >= 2 true → i--
// i = 2: nums[2] >= nums[3] → 5 >= 4 true → i--
// i = 1: nums[1] >= nums[2] → 3 >= 5 false

// Pivot:

// nums[i] = 3

// Find bigger from right:

// j = 4: nums[4] <= nums[1] → 2 <= 3 true → j--
// j = 3: nums[3] <= nums[1] → 4 <= 3 false

// So:

// nums[j] = 4

// Swap 3 and 4:

// [1,4,5,3,2]

// Reverse after pivot:

// [5,3,2] → [2,3,5]

// Final answer:

// [1,4,2,3,5]

// Final formula:

// Find pivot → find bigger element → swap → reverse right side