// i = 0
//    j = 1
//       try all left-right pairs
//    j = 2
//       try all left-right pairs
//    j = 3
//       try all left-right pairs

// i = 1
//    j = 2
//       try all left-right pairs
//    j = 3
//       try all left-right pairs

// i = 2
//    ...
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // This list will store final unique quadruplets
        List<List<Integer>> ans = new ArrayList<>();

        // Sort array so that two-pointer technique works
        // Also helps to skip duplicate values
        Arrays.sort(nums);

        int n = nums.length;

        // First number fixed using i
        // n - 3 because we need at least 3 numbers after i
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate value for i
            // Example: if nums[i] is same as previous nums[i-1],
            // then it will create duplicate quadruplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second number fixed using j
            // j starts from i + 1 because indices must be different
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate value for j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // left pointer starts after j
                int left = j + 1;

                // right pointer starts from last index
                int right = n - 1;

                // Now find two numbers using two-pointer approach
                while (left < right) {

                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    // If sum equals target, we found one quadruplet
                    if (sum == target) {

                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        // Move both pointers to search for new pair
                        left++;
                        right--;

                        // Skip duplicate values for left pointer
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate values for right pointer
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    }
                    // If sum is smaller than target,
                    // we need a bigger value, so move left forward
                    else if (sum < target) {
                        left++;
                    }
                    // If sum is greater than target,
                    // we need a smaller value, so move right backward
                    else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}

// Dry Run

// Input:

// nums = [1,0,-1,0,-2,2]
// target = 0

// After sorting:

// index:  0   1   2   3   4   5
// nums:  -2  -1   0   0   1   2
// First Loop: i = 0
// nums[i] = -2

// Now we choose second number using j.

// j = 1
// nums[j] = -1

// Now:

// i = 0  → -2
// j = 1  → -1
// left = 2  → 0
// right = 5 → 2

// Calculate sum:

// sum = -2 + (-1) + 0 + 2
// sum = -1

// Target is 0.

// Since:

// sum < target

// Move left++.

// Now:

// left = 3 → 0
// right = 5 → 2

// Again calculate:

// sum = -2 + (-1) + 0 + 2
// sum = -1

// Again sum < target, so move left++.

// Now:

// left = 4 → 1
// right = 5 → 2

// Calculate:

// sum = -2 + (-1) + 1 + 2
// sum = 0

// Valid quadruplet found:

// [-2, -1, 1, 2]

// Add to answer.

// Move both pointers:

// left++
// right--

// Now:

// left = 5
// right = 4

// Loop stops because left < right is false.

// Answer:

// [[-2, -1, 1, 2]]
// j = 2
// nums[j] = 0

// Now:

// i = 0  → -2
// j = 2  → 0
// left = 3  → 0
// right = 5 → 2

// Calculate:

// sum = -2 + 0 + 0 + 2
// sum = 0

// Valid quadruplet:

// [-2, 0, 0, 2]

// Add to answer.

// Move both:

// left = 4
// right = 4

// Loop stops.

// Answer:

// [[-2, -1, 1, 2], [-2, 0, 0, 2]]
// j = 3
// nums[j] = 0

// But previous value is also 0.

// Condition:

// if (j > i + 1 && nums[j] == nums[j - 1])

// Here:

// j = 3
// i + 1 = 1
// nums[3] = 0
// nums[2] = 0

// So this is duplicate.

// Skip it.

// Second Main Loop: i = 1
// nums[i] = -1
// j = 2
// nums[j] = 0
// left = 3 → 0
// right = 5 → 2

// Calculate:

// sum = -1 + 0 + 0 + 2
// sum = 1

// Since:

// sum > target

// Move right--.

// Now:

// left = 3 → 0
// right = 4 → 1

// Calculate:

// sum = -1 + 0 + 0 + 1
// sum = 0

// Valid quadruplet:

// [-1, 0, 0, 1]

// Add to answer.

// Move both:

// left = 4
// right = 3

// Loop stops.

// Answer:

// [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
// j = 3
// nums[j] = 0

// Previous value is also 0, so skip duplicate.

// Third Main Loop: i = 2
// nums[i] = 0

// Now j = 3.

// left = 4
// right = 5

// Calculate:

// sum = 0 + 0 + 1 + 2
// sum = 3

// Since 3 > 0, move right--.

// Now:

// left = 4
// right = 4

// Loop stops.

// Final Answer
// [[-2, -1, 1, 2],
//  [-2, 0, 0, 2],
//  [-1, 0, 0, 1]]
// Why Sorting Is Needed?

// Sorting helps in two ways:

// 1. Two-pointer logic works

// If sum is small, move left++.

// Because sorted array means moving left forward gives bigger value.

// [-2, -1, 0, 0, 1, 2]
//           ↑
//         bigger direction

// If sum is big, move right--.

// Because moving right backward gives smaller value.

// 2. Duplicate skipping becomes easy

// Example:

// [-2, -1, 0, 0, 1, 2]
//           ↑  ↑
//         duplicate

// We can skip repeated 0.

// Why Two Loops?

// Because we need 4 numbers.

// We fix first two numbers:

// nums[i] + nums[j] + ? + ? = target

// Then we find remaining two numbers using two pointers.

// Complete Flow
// Sort array

// For every i:
//     skip duplicate i

//     For every j:
//         skip duplicate j

//         left = j + 1
//         right = n - 1

//         while left < right:
//             find sum

//             if sum == target:
//                 store answer
//                 move left and right
//                 skip duplicates

//             else if sum < target:
//                 left++

//             else:
//                 right--
// Time Complexity
// O(n³)

// Because:

// i loop = O(n)
// j loop = O(n)
// two pointer = O(n)

// Total = O(n³)
// Space Complexity
// O(1)

// Extra space is constant, ignoring output list.

// why we increament j after condition left < right become false

// When left < right becomes false, it means:

// For the current fixed values of i and j, we have checked all possible pairs (left, right).

// So there are no more combinations possible with this j.

// That is why we exit the while loop and increment j to try a new second number.

// Structure of the Algorithm
// for (int i = 0; i < n - 3; i++) {
//     for (int j = i + 1; j < n - 2; j++) {

//         int left = j + 1;
//         int right = n - 1;

//         while (left < right) {
//             // check quadruplets
//         }

//         // while loop finished
//         // now j automatically increments
//     }
// }
// Meaning of Each Pointer
// i → first number
// j → second number
// left → third number
// right → fourth number

// So we are solving:

// nums[i] + nums[j] + nums[left] + nums[right] = target
// What Does the while Loop Do?

// For fixed i and j, the while loop tries all valid pairs:

// (left, right)

// Once left >= right, all possible pairs are exhausted.

// Example

// Sorted array:

// [-2, -1, 0, 0, 1, 2]

// Suppose:

// i = 0  -> -2
// j = 1  -> -1

// Then:

// left = 2
// right = 5

// Possible pairs checked:

// (2, 5)
// (3, 5)
// (4, 5)

// After that:

// left = 5
// right = 4

// Condition left < right is false.

// So there are no more pairs for:

// i = 0, j = 1

// Now we must try:

// j = 2
// Why Not Change i Directly?

// Because i is the first number.

// For the same i, there are still many possible values of j.

// So after finishing all pairs for one j, we increment j.

// Only after all j values are processed do we increment i.

// Real-Life Analogy

// Suppose you want 4 students whose marks sum to a target.

// i = first student
// j = second student
// left, right = two remaining students

// For one fixed pair of first and second students, you try every possible pair of remaining students.

// After exhausting them, you keep the first student the same and choose a new second student (j++).

// Flow Diagram
// Fix i
//     Fix j
//         Try all left-right pairs
//         left >= right → done with this j
//     j++
// Done with all j
// i++
// Simple Answer

// When left < right becomes false, it means all possible third and fourth numbers have been checked for the current i and j. Therefore, we increment j to choose a new second number and search for more quadruplets.

// Tiny Example
// i = -2
// j = -1
// Try all left-right pairs
// No more pairs
// → Increment j to 0
// Try all left-right pairs again
// then when all j finishes we aslo increment i and try all i values

// Exactly! ✅ That is precisely how the algorithm works.

// Overall Algorithm Flow

// We have three levels:

// i loop → selects the 1st number.
// j loop → selects the 2nd number.
// left and right pointers → find the 3rd and 4th numbers.
// Structure
// for (int i = 0; i < n - 3; i++) {          // First number

//     for (int j = i + 1; j < n - 2; j++) {  // Second number

//         int left = j + 1;                  // Third number
//         int right = n - 1;                 // Fourth number

//         while (left < right) {
//             // Check sum
//         }
//     }
// }
// Step-by-Step Flow
// 1. Fix i

// Choose the first number.

// Example:

// i = 0 → nums[i] = -2
// 2. Try All j

// For the same i, try every possible second number.

// j = 1
// j = 2
// j = 3
// ...
// 3. For Each j, Try All (left, right) Pairs

// The while loop checks all possible third and fourth numbers.

// 4. When left >= right

// All pairs for this j are done.

// So:

// j++
// 5. When All j Values Are Done

// All second numbers for this i are completed.

// So:

// i++
// Visual Flow
// i = 0
//    j = 1
//       try all left-right pairs
//    j = 2
//       try all left-right pairs
//    j = 3
//       try all left-right pairs

// i = 1
//    j = 2
//       try all left-right pairs
//    j = 3
//       try all left-right pairs

// i = 2
//    ...
// Example with Sorted Array
// [-2, -1, 0, 0, 1, 2]
// i = 0 (-2)
// j = 1 (-1)

// Try all pairs.

// j = 2 (0)

// Try all pairs.

// j = 3 (0)

// Skipped because duplicate.

// j = 4

// Not allowed because not enough numbers left.

// Done with all j.

// i = 1 (-1)
// j = 2 (0)

// Try all pairs.

// j = 3 (0)

// Skipped because duplicate.

// Done with all j.

// i = 2 (0)
// j = 3 (0)

// Try all pairs.

// Done.

// Why This Covers All Quadruplets

// Every quadruplet has four indices:

// i < j < left < right

// The algorithm systematically explores all such combinations without duplicates.

// Interview Answer

// Yes. For each fixed i, we iterate through all valid j values. For each (i, j) pair, we use two pointers to examine all possible pairs (left, right). After all j values are processed, we increment i and repeat the process.

// Simple Memory Trick

// Fix one number (i), try all second numbers (j), and for each pair, search the remaining two numbers with two pointers.

// Final Summary

// Yes, the algorithm works exactly like this:

// Choose one i.
// Try every valid j.
// For each (i, j), try all (left, right) pairs.
// When all j values are exhausted, increment i.
// Repeat until all possible i values are processed.

// So the complete exploration is:

// For every i
//     For every j
//         For all left-right pairs