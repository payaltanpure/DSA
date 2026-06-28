// 169. Majority Element
// Easy
// Topics
// premium lock icon
// Companies
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2



// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;

//         // Check frequency of every element
//         for (int i = 0; i < n; i++) {
//             int count = 0;

//             // Count how many times nums[i] appears
//             for (int j = 0; j < n; j++) {
//                 if (nums[j] == nums[i]) {
//                     count++;
//                 }
//             }

//             // If frequency is greater than n/2,
//             // nums[i] is the majority element
//             if (count > n / 2) {
//                 return nums[i];
//             }
//         }

//         // Problem guarantees a majority element always exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// We need an element appearing more than 3 times.



// Outer Loop Iteration 1
// i = 0
// nums[i] = 2count = 0
// Now the inner loop counts how many times 2 appears.

// Inner Loop
// jnums[j]Compare with nums[i] = 2count02Equal112Equal221Not Equal231Not Equal241Not Equal252Equal362Equal4
// Final count = 4

// Check Majority Condition
// count = 4n/2 = 3
// Since:
// 4 > 3
// The element 2 is the majority element.
// Return 2.

// Program Stops Here
// No further iterations are needed.

// Final Output
// 2

// Visual Representation
// nums = [2, 2, 1, 1, 1, 2, 2]        ↑      nums[i] = 2
// Occurrences of 2:
// 2, 2, _, _, _, 2, 2
// Total occurrences = 4
// Since 4 > 3, return 2.

// Time Complexity


// Outer loop runs n times.


// Inner loop runs n times.


// Total = O(n²).


// Space Complexity


// Uses only n, i, j, and count.


// Total = O(1).





// // import java.util.HashMap;

// // class Solution {
// //     public int majorityElement(int[] nums) {
// //         HashMap<Integer, Integer> map = new HashMap<>();
// //         int n = nums.length;

//         // Count frequency of each element
//         for (int num : nums) {
//             // Increase count of current number
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             // If count becomes greater than n/2,
//             // this is the majority element
//             if (map.get(num) > n / 2) {
//                 return num;
//             }
//         }

//         // Problem guarantees majority element exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// Need an element appearing more than 3 times.



// Step-by-Step Dry Run
// Initially:
// map = {}

// Iteration 1
// num = 2
// map.put(2, map.getOrDefault(2, 0) + 1);


// map.getOrDefault(2, 0) → 0


// New count = 1


// Map:
// {2=1}
// Check:
// 1 > 3 ? No

// Iteration 2
// num = 2
// Current count = 1
// New count = 2
// Map:
// {2=2}
// Check:
// 2 > 3 ? No

// Iteration 3
// num = 1
// New count = 1
// Map:
// {2=2, 1=1}
// Check:
// 1 > 3 ? No

// Iteration 4
// num = 1
// New count = 2
// Map:
// {2=2, 1=2}
// Check:
// 2 > 3 ? No

// Iteration 5
// num = 1
// New count = 3
// Map:
// {2=2, 1=3}
// Check:
// 3 > 3 ? No
// Remember, majority means strictly greater than n/2.

// Iteration 6
// num = 2
// New count = 3
// Map:
// {2=3, 1=3}
// Check:
// 3 > 3 ? No

// Iteration 7
// num = 2
// New count = 4
// Map:
// {2=4, 1=3}
// Check:
// 4 > 3 ? Yes
// Return 2.

// Final Output
// 2

// How getOrDefault() Works
// map.getOrDefault(num, 0)


// If key exists → returns its current value.


// If key does not exist → returns 0.


// Examples:


// map.getOrDefault(2, 0) → 2


// map.getOrDefault(5, 0) → 0



// Time Complexity
// Each element is processed once.


// Time: O(n)


// Space Complexity
// In the worst case, all elements are distinct.


// Space: O(n)


// import java.util.Arrays;

// class Solution {
//     public int majorityElement(int[] nums) {
//         // Sort the array
//         Arrays.sort(nums);

//         // After sorting, the majority element
//         // will always be at index n/2
//         return nums[nums.length / 2];
//     }
// }

# Dry Run of Sorting Approach

## Java Code

```java id="ttv7bn"
import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Return the middle element
        return nums[nums.length / 2];
    }
}
```

// ---

// ## Example Input

// ```text id="9kz2r6"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * `n / 2 = 3`

// ---

// # Step 1: Sort the Array

// Before sorting:

// ```text id="qebrb2"
// [2, 2, 1, 1, 1, 2, 2]
// ```

// After sorting:

// ```text id="y9kzrz"
// [1, 1, 1, 2, 2, 2, 2]
// ```

// ---

// # Step 2: Find Middle Index

// ```java id="yr7jyl"
// nums.length / 2 = 7 / 2 = 3
// ```

// Middle index = `3`

// ---

// # Step 3: Return Element at Index 3

// Sorted array with indices:

// | Index |  0 |  1 |  2 |  3 |  4 |  5 |  6 |
// | ----: | -: | -: | -: | -: | -: | -: | -: |
// | Value |  1 |  1 |  1 |  2 |  2 |  2 |  2 |

// ```text id="j3hr3l"
// nums[3] = 2
// ```

// Return `2`.

// ---

// # Why Middle Element Is Always the Majority

// The majority element appears more than `n/2` times, so it must occupy the middle position after sorting.

// For this example:

// ```text id="1o0p7r"
// [1, 1, 1, 2, 2, 2, 2]
//           ↑
//        middle element
// ```

// Since `2` occurs 4 times (more than 3), it covers the middle index.

// ---

// # Final Output

// ```text id="sm11rm"
// 2
// ```

// ---

// # Another Example

// Input:

// ```text id="nwr67v"
// [3, 2, 3]
// ```

// Sorted:

// ```text id="1mn91l"
// [2, 3, 3]
// ```

// * `n = 3`
// * `n / 2 = 1`

// ```text id="1ln7f5"
// nums[1] = 3
// ```

// Return `3`.

// ---

// # Time Complexity

// Sorting takes:

// * `O(n log n)`

// # Space Complexity

// Depends on sorting implementation, but commonly:

// * `O(log n)` (recursion stack) or `O(1)` extra space depending on the algorithm.


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0,
            // choose current number as new candidate
            if (count == 0) {
                candidate = num;
            }

            // If current number is same as candidate,
            // increase count
            if (num == candidate) {
                count++;
            }
            // Otherwise decrease count
            else {
                count--;
            }
        }

        // Since the problem guarantees that
        // a majority element always exists,
        // candidate is the answer.
        return candidate;
    }
}


// Core Idea

// Think of this as a voting system:

// Same number as candidate → gets one vote.
// Different number → loses one vote.
// When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// # Dry Run of Boyer-Moore Voting Algorithm (Optimal Approach)

// ## Java Code

// ```java id="q3k0rn"
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0, choose new candidate
            if (count == 0) {
                candidate = num;
            }

            // Same element → increase vote
            if (num == candidate) {
                count++;
            }
            // Different element → decrease vote
            else {
                count--;
            }
        }

        return candidate;
    }
}

// ---

// # Example Input

// ```text id="ab7r6h"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * Majority element appears more than `7/2 = 3` times.
// * `2` appears 4 times.

// ---

// # Core Idea

// Think of this as a voting system:

// * Same number as candidate → gets one vote.
// * Different number → loses one vote.
// * When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// ---

// # Step-by-Step Dry Run

// Initially:

// ```text id="m71l1f"
// candidate = 0
// count = 0
// ```

// ---

// ## Iteration 1: num = 2

// ### count == 0

// Set:

// ```text id="5r6pjo"
// candidate = 2
// ```

// Since `num == candidate`:

// ```text id="owjlwm"
// count = 1
// ```

// ---

// ## Iteration 2: num = 2

// `num == candidate`

// ```text id="p2o0wu"
// count = 2
// ```

// ---

// ## Iteration 3: num = 1

// `num != candidate`

// ```text id="4lh50q"
// count = 1
// ```

// ---

// ## Iteration 4: num = 1

// `num != candidate`

// ```text id="7qns4k"
// count = 0
// ```

// ---

// ## Iteration 5: num = 1

// ### count == 0

// Set:

// ```text id="1m0f0w"
// candidate = 1
// ```

// `num == candidate`

// ```text id="vh70an"
// count = 1
// ```

// ---

// ## Iteration 6: num = 2

// `num != candidate`

// ```text id="6e2o9p"
// count = 0
// ```

// ---

// ## Iteration 7: num = 2

// ### count == 0

// Set:

// ```text id="w6m4uk"
// candidate = 2
// ```

// `num == candidate`

// ```text id="wlm0hv"
// count = 1
// ```

// ---

// # Final Result

// ```text id="sf01sm"
// candidate = 2
// ```

// Return `2`.

// ---

// # Dry Run Table

// | Step | num | count before | Action                       | candidate after | count after |
// | ---: | --: | -----------: | ---------------------------- | --------------: | ----------: |
// |    1 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |
// |    2 |   2 |            1 | Same, increment              |               2 |           2 |
// |    3 |   1 |            2 | Different, decrement         |               2 |           1 |
// |    4 |   1 |            1 | Different, decrement         |               2 |           0 |
// |    5 |   1 |            0 | Set candidate = 1, increment |               1 |           1 |
// |    6 |   2 |            1 | Different, decrement         |               1 |           0 |
// |    7 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |

// Final answer = `2`.

// ---

// # Cancellation Visualization

// ```text id="s5y8qa"
// 2  2  1  1  1  2  2
//    ×  ×  ×
// Remaining majority element = 2
// ```

// Each different element cancels one occurrence of the current candidate.

// ---

// # Why It Works

// The majority element occurs more than all other elements combined, so it cannot be completely canceled out.

// ---

// # Time Complexity

// * `O(n)`

// # Space Complexity

// * `O(1)`

// ---

// # Interview One-Line Explanation

// > Maintain a candidate and a vote count. Increase the count for the same element, decrease it for a different element, and reset the candidate when the count becomes zero. The majority element survives all cancellations.


// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;

//         // Check frequency of every element
//         for (int i = 0; i < n; i++) {
//             int count = 0;

//             // Count how many times nums[i] appears
//             for (int j = 0; j < n; j++) {
//                 if (nums[j] == nums[i]) {
//                     count++;
//                 }
//             }

//             // If frequency is greater than n/2,
//             // nums[i] is the majority element
//             if (count > n / 2) {
//                 return nums[i];
//             }
//         }

//         // Problem guarantees a majority element always exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// We need an element appearing more than 3 times.



// Outer Loop Iteration 1
// i = 0
// nums[i] = 2count = 0
// Now the inner loop counts how many times 2 appears.

// Inner Loop
// jnums[j]Compare with nums[i] = 2count02Equal112Equal221Not Equal231Not Equal241Not Equal252Equal362Equal4
// Final count = 4

// Check Majority Condition
// count = 4n/2 = 3
// Since:
// 4 > 3
// The element 2 is the majority element.
// Return 2.

// Program Stops Here
// No further iterations are needed.

// Final Output
// 2

// Visual Representation
// nums = [2, 2, 1, 1, 1, 2, 2]        ↑      nums[i] = 2
// Occurrences of 2:
// 2, 2, _, _, _, 2, 2
// Total occurrences = 4
// Since 4 > 3, return 2.

// Time Complexity


// Outer loop runs n times.


// Inner loop runs n times.


// Total = O(n²).


// Space Complexity


// Uses only n, i, j, and count.


// Total = O(1).





// // import java.util.HashMap;

// // class Solution {
// //     public int majorityElement(int[] nums) {
// //         HashMap<Integer, Integer> map = new HashMap<>();
// //         int n = nums.length;

//         // Count frequency of each element
//         for (int num : nums) {
//             // Increase count of current number
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             // If count becomes greater than n/2,
//             // this is the majority element
//             if (map.get(num) > n / 2) {
//                 return num;
//             }
//         }

//         // Problem guarantees majority element exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// Need an element appearing more than 3 times.



// Step-by-Step Dry Run
// Initially:
// map = {}

// Iteration 1
// num = 2
// map.put(2, map.getOrDefault(2, 0) + 1);


// map.getOrDefault(2, 0) → 0


// New count = 1


// Map:
// {2=1}
// Check:
// 1 > 3 ? No

// Iteration 2
// num = 2
// Current count = 1
// New count = 2
// Map:
// {2=2}
// Check:
// 2 > 3 ? No

// Iteration 3
// num = 1
// New count = 1
// Map:
// {2=2, 1=1}
// Check:
// 1 > 3 ? No

// Iteration 4
// num = 1
// New count = 2
// Map:
// {2=2, 1=2}
// Check:
// 2 > 3 ? No

// Iteration 5
// num = 1
// New count = 3
// Map:
// {2=2, 1=3}
// Check:
// 3 > 3 ? No
// Remember, majority means strictly greater than n/2.

// Iteration 6
// num = 2
// New count = 3
// Map:
// {2=3, 1=3}
// Check:
// 3 > 3 ? No

// Iteration 7
// num = 2
// New count = 4
// Map:
// {2=4, 1=3}
// Check:
// 4 > 3 ? Yes
// Return 2.

// Final Output
// 2

// How getOrDefault() Works
// map.getOrDefault(num, 0)


// If key exists → returns its current value.


// If key does not exist → returns 0.


// Examples:


// map.getOrDefault(2, 0) → 2


// map.getOrDefault(5, 0) → 0



// Time Complexity
// Each element is processed once.


// Time: O(n)


// Space Complexity
// In the worst case, all elements are distinct.


// Space: O(n)


// import java.util.Arrays;

// class Solution {
//     public int majorityElement(int[] nums) {
//         // Sort the array
//         Arrays.sort(nums);

//         // After sorting, the majority element
//         // will always be at index n/2
//         return nums[nums.length / 2];
//     }
// }

# Dry Run of Sorting Approach

## Java Code

```java id="ttv7bn"
import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Return the middle element
        return nums[nums.length / 2];
    }
}
```

// ---

// ## Example Input

// ```text id="9kz2r6"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * `n / 2 = 3`

// ---

// # Step 1: Sort the Array

// Before sorting:

// ```text id="qebrb2"
// [2, 2, 1, 1, 1, 2, 2]
// ```

// After sorting:

// ```text id="y9kzrz"
// [1, 1, 1, 2, 2, 2, 2]
// ```

// ---

// # Step 2: Find Middle Index

// ```java id="yr7jyl"
// nums.length / 2 = 7 / 2 = 3
// ```

// Middle index = `3`

// ---

// # Step 3: Return Element at Index 3

// Sorted array with indices:

// | Index |  0 |  1 |  2 |  3 |  4 |  5 |  6 |
// | ----: | -: | -: | -: | -: | -: | -: | -: |
// | Value |  1 |  1 |  1 |  2 |  2 |  2 |  2 |

// ```text id="j3hr3l"
// nums[3] = 2
// ```

// Return `2`.

// ---

// # Why Middle Element Is Always the Majority

// The majority element appears more than `n/2` times, so it must occupy the middle position after sorting.

// For this example:

// ```text id="1o0p7r"
// [1, 1, 1, 2, 2, 2, 2]
//           ↑
//        middle element
// ```

// Since `2` occurs 4 times (more than 3), it covers the middle index.

// ---

// # Final Output

// ```text id="sm11rm"
// 2
// ```

// ---

// # Another Example

// Input:

// ```text id="nwr67v"
// [3, 2, 3]
// ```

// Sorted:

// ```text id="1mn91l"
// [2, 3, 3]
// ```

// * `n = 3`
// * `n / 2 = 1`

// ```text id="1ln7f5"
// nums[1] = 3
// ```

// Return `3`.

// ---

// # Time Complexity

// Sorting takes:

// * `O(n log n)`

// # Space Complexity

// Depends on sorting implementation, but commonly:

// * `O(log n)` (recursion stack) or `O(1)` extra space depending on the algorithm.


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0,
            // choose current number as new candidate
            if (count == 0) {
                candidate = num;
            }

            // If current number is same as candidate,
            // increase count
            if (num == candidate) {
                count++;
            }
            // Otherwise decrease count
            else {
                count--;
            }
        }

        // Since the problem guarantees that
        // a majority element always exists,
        // candidate is the answer.
        return candidate;
    }
}


// Core Idea

// Think of this as a voting system:

// Same number as candidate → gets one vote.
// Different number → loses one vote.
// When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// # Dry Run of Boyer-Moore Voting Algorithm (Optimal Approach)

// ## Java Code

// ```java id="q3k0rn"
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0, choose new candidate
            if (count == 0) {
                candidate = num;
            }

            // Same element → increase vote
            if (num == candidate) {
                count++;
            }
            // Different element → decrease vote
            else {
                count--;
            }
        }

        return candidate;
    }
}

// ---

// # Example Input

// ```text id="ab7r6h"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * Majority element appears more than `7/2 = 3` times.
// * `2` appears 4 times.

// ---

// # Core Idea

// Think of this as a voting system:

// * Same number as candidate → gets one vote.
// * Different number → loses one vote.
// * When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// ---

// # Step-by-Step Dry Run

// Initially:

// ```text id="m71l1f"
// candidate = 0
// count = 0
// ```

// ---

// ## Iteration 1: num = 2

// ### count == 0

// Set:

// ```text id="5r6pjo"
// candidate = 2
// ```

// Since `num == candidate`:

// ```text id="owjlwm"
// count = 1
// ```

// ---

// ## Iteration 2: num = 2

// `num == candidate`

// ```text id="p2o0wu"
// count = 2
// ```

// ---

// ## Iteration 3: num = 1

// `num != candidate`

// ```text id="4lh50q"
// count = 1
// ```

// ---

// ## Iteration 4: num = 1

// `num != candidate`

// ```text id="7qns4k"
// count = 0
// ```

// ---

// ## Iteration 5: num = 1

// ### count == 0

// Set:

// ```text id="1m0f0w"
// candidate = 1
// ```

// `num == candidate`

// ```text id="vh70an"
// count = 1
// ```

// ---

// ## Iteration 6: num = 2

// `num != candidate`

// ```text id="6e2o9p"
// count = 0
// ```

// ---

// ## Iteration 7: num = 2

// ### count == 0

// Set:

// ```text id="w6m4uk"
// candidate = 2
// ```

// `num == candidate`

// ```text id="wlm0hv"
// count = 1
// ```

// ---

// # Final Result

// ```text id="sf01sm"
// candidate = 2
// ```

// Return `2`.

// ---

// # Dry Run Table

// | Step | num | count before | Action                       | candidate after | count after |
// | ---: | --: | -----------: | ---------------------------- | --------------: | ----------: |
// |    1 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |
// |    2 |   2 |            1 | Same, increment              |               2 |           2 |
// |    3 |   1 |            2 | Different, decrement         |               2 |           1 |
// |    4 |   1 |            1 | Different, decrement         |               2 |           0 |
// |    5 |   1 |            0 | Set candidate = 1, increment |               1 |           1 |
// |    6 |   2 |            1 | Different, decrement         |               1 |           0 |
// |    7 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |

// Final answer = `2`.

// ---

// # Cancellation Visualization

// ```text id="s5y8qa"
// 2  2  1  1  1  2  2
//    ×  ×  ×
// Remaining majority element = 2
// ```

// Each different element cancels one occurrence of the current candidate.

// ---

// # Why It Works

// The majority element occurs more than all other elements combined, so it cannot be completely canceled out.

// ---

// # Time Complexity

// * `O(n)`

// # Space Complexity

// * `O(1)`

// ---

// # Interview One-Line Explanation

// > Maintain a candidate and a vote count. Increase the count for the same element, decrease it for a different element, and reset the candidate when the count becomes zero. The majority element survives all cancellations.

// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;

//         // Check frequency of every element
//         for (int i = 0; i < n; i++) {
//             int count = 0;

//             // Count how many times nums[i] appears
//             for (int j = 0; j < n; j++) {
//                 if (nums[j] == nums[i]) {
//                     count++;
//                 }
//             }

//             // If frequency is greater than n/2,
//             // nums[i] is the majority element
//             if (count > n / 2) {
//                 return nums[i];
//             }
//         }

//         // Problem guarantees a majority element always exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// We need an element appearing more than 3 times.



// Outer Loop Iteration 1
// i = 0
// nums[i] = 2count = 0
// Now the inner loop counts how many times 2 appears.

// Inner Loop
// jnums[j]Compare with nums[i] = 2count02Equal112Equal221Not Equal231Not Equal241Not Equal252Equal362Equal4
// Final count = 4

// Check Majority Condition
// count = 4n/2 = 3
// Since:
// 4 > 3
// The element 2 is the majority element.
// Return 2.

// Program Stops Here
// No further iterations are needed.

// Final Output
// 2

// Visual Representation
// nums = [2, 2, 1, 1, 1, 2, 2]        ↑      nums[i] = 2
// Occurrences of 2:
// 2, 2, _, _, _, 2, 2
// Total occurrences = 4
// Since 4 > 3, return 2.

// Time Complexity


// Outer loop runs n times.


// Inner loop runs n times.


// Total = O(n²).


// Space Complexity


// Uses only n, i, j, and count.


// Total = O(1).





// // import java.util.HashMap;

// // class Solution {
// //     public int majorityElement(int[] nums) {
// //         HashMap<Integer, Integer> map = new HashMap<>();
// //         int n = nums.length;

//         // Count frequency of each element
//         for (int num : nums) {
//             // Increase count of current number
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             // If count becomes greater than n/2,
//             // this is the majority element
//             if (map.get(num) > n / 2) {
//                 return num;
//             }
//         }

//         // Problem guarantees majority element exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// Need an element appearing more than 3 times.



// Step-by-Step Dry Run
// Initially:
// map = {}

// Iteration 1
// num = 2
// map.put(2, map.getOrDefault(2, 0) + 1);


// map.getOrDefault(2, 0) → 0


// New count = 1


// Map:
// {2=1}
// Check:
// 1 > 3 ? No

// Iteration 2
// num = 2
// Current count = 1
// New count = 2
// Map:
// {2=2}
// Check:
// 2 > 3 ? No

// Iteration 3
// num = 1
// New count = 1
// Map:
// {2=2, 1=1}
// Check:
// 1 > 3 ? No

// Iteration 4
// num = 1
// New count = 2
// Map:
// {2=2, 1=2}
// Check:
// 2 > 3 ? No

// Iteration 5
// num = 1
// New count = 3
// Map:
// {2=2, 1=3}
// Check:
// 3 > 3 ? No
// Remember, majority means strictly greater than n/2.

// Iteration 6
// num = 2
// New count = 3
// Map:
// {2=3, 1=3}
// Check:
// 3 > 3 ? No

// Iteration 7
// num = 2
// New count = 4
// Map:
// {2=4, 1=3}
// Check:
// 4 > 3 ? Yes
// Return 2.

// Final Output
// 2

// How getOrDefault() Works
// map.getOrDefault(num, 0)


// If key exists → returns its current value.


// If key does not exist → returns 0.


// Examples:


// map.getOrDefault(2, 0) → 2


// map.getOrDefault(5, 0) → 0



// Time Complexity
// Each element is processed once.


// Time: O(n)


// Space Complexity
// In the worst case, all elements are distinct.


// Space: O(n)


// import java.util.Arrays;

// class Solution {
//     public int majorityElement(int[] nums) {
//         // Sort the array
//         Arrays.sort(nums);

//         // After sorting, the majority element
//         // will always be at index n/2
//         return nums[nums.length / 2];
//     }
// }

# Dry Run of Sorting Approach

## Java Code

```java id="ttv7bn"
import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Return the middle element
        return nums[nums.length / 2];
    }
}
```

// ---

// ## Example Input

// ```text id="9kz2r6"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * `n / 2 = 3`

// ---

// # Step 1: Sort the Array

// Before sorting:

// ```text id="qebrb2"
// [2, 2, 1, 1, 1, 2, 2]
// ```

// After sorting:

// ```text id="y9kzrz"
// [1, 1, 1, 2, 2, 2, 2]
// ```

// ---

// # Step 2: Find Middle Index

// ```java id="yr7jyl"
// nums.length / 2 = 7 / 2 = 3
// ```

// Middle index = `3`

// ---

// # Step 3: Return Element at Index 3

// Sorted array with indices:

// | Index |  0 |  1 |  2 |  3 |  4 |  5 |  6 |
// | ----: | -: | -: | -: | -: | -: | -: | -: |
// | Value |  1 |  1 |  1 |  2 |  2 |  2 |  2 |

// ```text id="j3hr3l"
// nums[3] = 2
// ```

// Return `2`.

// ---

// # Why Middle Element Is Always the Majority

// The majority element appears more than `n/2` times, so it must occupy the middle position after sorting.

// For this example:

// ```text id="1o0p7r"
// [1, 1, 1, 2, 2, 2, 2]
//           ↑
//        middle element
// ```

// Since `2` occurs 4 times (more than 3), it covers the middle index.

// ---

// # Final Output

// ```text id="sm11rm"
// 2
// ```

// ---

// # Another Example

// Input:

// ```text id="nwr67v"
// [3, 2, 3]
// ```

// Sorted:

// ```text id="1mn91l"
// [2, 3, 3]
// ```

// * `n = 3`
// * `n / 2 = 1`

// ```text id="1ln7f5"
// nums[1] = 3
// ```

// Return `3`.

// ---

// # Time Complexity

// Sorting takes:

// * `O(n log n)`

// # Space Complexity

// Depends on sorting implementation, but commonly:

// * `O(log n)` (recursion stack) or `O(1)` extra space depending on the algorithm.


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0,
            // choose current number as new candidate
            if (count == 0) {
                candidate = num;
            }

            // If current number is same as candidate,
            // increase count
            if (num == candidate) {
                count++;
            }
            // Otherwise decrease count
            else {
                count--;
            }
        }

        // Since the problem guarantees that
        // a majority element always exists,
        // candidate is the answer.
        return candidate;
    }
}


// Core Idea

// Think of this as a voting system:

// Same number as candidate → gets one vote.
// Different number → loses one vote.
// When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// # Dry Run of Boyer-Moore Voting Algorithm (Optimal Approach)

// ## Java Code

// ```java id="q3k0rn"
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0, choose new candidate
            if (count == 0) {
                candidate = num;
            }

            // Same element → increase vote
            if (num == candidate) {
                count++;
            }
            // Different element → decrease vote
            else {
                count--;
            }
        }

        return candidate;
    }
}

// ---

// # Example Input

// ```text id="ab7r6h"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * Majority element appears more than `7/2 = 3` times.
// * `2` appears 4 times.

// ---

// # Core Idea

// Think of this as a voting system:

// * Same number as candidate → gets one vote.
// * Different number → loses one vote.
// * When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// ---

// # Step-by-Step Dry Run

// Initially:

// ```text id="m71l1f"
// candidate = 0
// count = 0
// ```

// ---

// ## Iteration 1: num = 2

// ### count == 0

// Set:

// ```text id="5r6pjo"
// candidate = 2
// ```

// Since `num == candidate`:

// ```text id="owjlwm"
// count = 1
// ```

// ---

// ## Iteration 2: num = 2

// `num == candidate`

// ```text id="p2o0wu"
// count = 2
// ```

// ---

// ## Iteration 3: num = 1

// `num != candidate`

// ```text id="4lh50q"
// count = 1
// ```

// ---

// ## Iteration 4: num = 1

// `num != candidate`

// ```text id="7qns4k"
// count = 0
// ```

// ---

// ## Iteration 5: num = 1

// ### count == 0

// Set:

// ```text id="1m0f0w"
// candidate = 1
// ```

// `num == candidate`

// ```text id="vh70an"
// count = 1
// ```

// ---

// ## Iteration 6: num = 2

// `num != candidate`

// ```text id="6e2o9p"
// count = 0
// ```

// ---

// ## Iteration 7: num = 2

// ### count == 0

// Set:

// ```text id="w6m4uk"
// candidate = 2
// ```

// `num == candidate`

// ```text id="wlm0hv"
// count = 1
// ```

// ---

// # Final Result

// ```text id="sf01sm"
// candidate = 2
// ```

// Return `2`.

// ---

// # Dry Run Table

// | Step | num | count before | Action                       | candidate after | count after |
// | ---: | --: | -----------: | ---------------------------- | --------------: | ----------: |
// |    1 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |
// |    2 |   2 |            1 | Same, increment              |               2 |           2 |
// |    3 |   1 |            2 | Different, decrement         |               2 |           1 |
// |    4 |   1 |            1 | Different, decrement         |               2 |           0 |
// |    5 |   1 |            0 | Set candidate = 1, increment |               1 |           1 |
// |    6 |   2 |            1 | Different, decrement         |               1 |           0 |
// |    7 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |

// Final answer = `2`.

// ---

// # Cancellation Visualization

// ```text id="s5y8qa"
// 2  2  1  1  1  2  2
//    ×  ×  ×
// Remaining majority element = 2
// ```

// Each different element cancels one occurrence of the current candidate.

// ---

// # Why It Works

// The majority element occurs more than all other elements combined, so it cannot be completely canceled out.

// ---

// # Time Complexity

// * `O(n)`

// # Space Complexity

// * `O(1)`

// ---

// # Interview One-Line Explanation

// > Maintain a candidate and a vote count. Increase the count for the same element, decrease it for a different element, and reset the candidate when the count becomes zero. The majority element survives all cancellations.


// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;

//         // Check frequency of every element
//         for (int i = 0; i < n; i++) {
//             int count = 0;

//             // Count how many times nums[i] appears
//             for (int j = 0; j < n; j++) {
//                 if (nums[j] == nums[i]) {
//                     count++;
//                 }
//             }

//             // If frequency is greater than n/2,
//             // nums[i] is the majority element
//             if (count > n / 2) {
//                 return nums[i];
//             }
//         }

//         // Problem guarantees a majority element always exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// We need an element appearing more than 3 times.



// Outer Loop Iteration 1
// i = 0
// nums[i] = 2count = 0
// Now the inner loop counts how many times 2 appears.

// Inner Loop
// jnums[j]Compare with nums[i] = 2count02Equal112Equal221Not Equal231Not Equal241Not Equal252Equal362Equal4
// Final count = 4

// Check Majority Condition
// count = 4n/2 = 3
// Since:
// 4 > 3
// The element 2 is the majority element.
// Return 2.

// Program Stops Here
// No further iterations are needed.

// Final Output
// 2

// Visual Representation
// nums = [2, 2, 1, 1, 1, 2, 2]        ↑      nums[i] = 2
// Occurrences of 2:
// 2, 2, _, _, _, 2, 2
// Total occurrences = 4
// Since 4 > 3, return 2.

// Time Complexity


// Outer loop runs n times.


// Inner loop runs n times.


// Total = O(n²).


// Space Complexity


// Uses only n, i, j, and count.


// Total = O(1).





// // import java.util.HashMap;

// // class Solution {
// //     public int majorityElement(int[] nums) {
// //         HashMap<Integer, Integer> map = new HashMap<>();
// //         int n = nums.length;

//         // Count frequency of each element
//         for (int num : nums) {
//             // Increase count of current number
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             // If count becomes greater than n/2,
//             // this is the majority element
//             if (map.get(num) > n / 2) {
//                 return num;
//             }
//         }

//         // Problem guarantees majority element exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// Need an element appearing more than 3 times.



// Step-by-Step Dry Run
// Initially:
// map = {}

// Iteration 1
// num = 2
// map.put(2, map.getOrDefault(2, 0) + 1);


// map.getOrDefault(2, 0) → 0


// New count = 1


// Map:
// {2=1}
// Check:
// 1 > 3 ? No

// Iteration 2
// num = 2
// Current count = 1
// New count = 2
// Map:
// {2=2}
// Check:
// 2 > 3 ? No

// Iteration 3
// num = 1
// New count = 1
// Map:
// {2=2, 1=1}
// Check:
// 1 > 3 ? No

// Iteration 4
// num = 1
// New count = 2
// Map:
// {2=2, 1=2}
// Check:
// 2 > 3 ? No

// Iteration 5
// num = 1
// New count = 3
// Map:
// {2=2, 1=3}
// Check:
// 3 > 3 ? No
// Remember, majority means strictly greater than n/2.

// Iteration 6
// num = 2
// New count = 3
// Map:
// {2=3, 1=3}
// Check:
// 3 > 3 ? No

// Iteration 7
// num = 2
// New count = 4
// Map:
// {2=4, 1=3}
// Check:
// 4 > 3 ? Yes
// Return 2.

// Final Output
// 2

// How getOrDefault() Works
// map.getOrDefault(num, 0)


// If key exists → returns its current value.


// If key does not exist → returns 0.


// Examples:


// map.getOrDefault(2, 0) → 2


// map.getOrDefault(5, 0) → 0



// Time Complexity
// Each element is processed once.


// Time: O(n)


// Space Complexity
// In the worst case, all elements are distinct.


// Space: O(n)


// import java.util.Arrays;

// class Solution {
//     public int majorityElement(int[] nums) {
//         // Sort the array
//         Arrays.sort(nums);

//         // After sorting, the majority element
//         // will always be at index n/2
//         return nums[nums.length / 2];
//     }
// }

# Dry Run of Sorting Approach

## Java Code

```java id="ttv7bn"
import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Return the middle element
        return nums[nums.length / 2];
    }
}
```

// ---

// ## Example Input

// ```text id="9kz2r6"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * `n / 2 = 3`

// ---

// # Step 1: Sort the Array

// Before sorting:

// ```text id="qebrb2"
// [2, 2, 1, 1, 1, 2, 2]
// ```

// After sorting:

// ```text id="y9kzrz"
// [1, 1, 1, 2, 2, 2, 2]
// ```

// ---

// # Step 2: Find Middle Index

// ```java id="yr7jyl"
// nums.length / 2 = 7 / 2 = 3
// ```

// Middle index = `3`

// ---

// # Step 3: Return Element at Index 3

// Sorted array with indices:

// | Index |  0 |  1 |  2 |  3 |  4 |  5 |  6 |
// | ----: | -: | -: | -: | -: | -: | -: | -: |
// | Value |  1 |  1 |  1 |  2 |  2 |  2 |  2 |

// ```text id="j3hr3l"
// nums[3] = 2
// ```

// Return `2`.

// ---

// # Why Middle Element Is Always the Majority

// The majority element appears more than `n/2` times, so it must occupy the middle position after sorting.

// For this example:

// ```text id="1o0p7r"
// [1, 1, 1, 2, 2, 2, 2]
//           ↑
//        middle element
// ```

// Since `2` occurs 4 times (more than 3), it covers the middle index.

// ---

// # Final Output

// ```text id="sm11rm"
// 2
// ```

// ---

// # Another Example

// Input:

// ```text id="nwr67v"
// [3, 2, 3]
// ```

// Sorted:

// ```text id="1mn91l"
// [2, 3, 3]
// ```

// * `n = 3`
// * `n / 2 = 1`

// ```text id="1ln7f5"
// nums[1] = 3
// ```

// Return `3`.

// ---

// # Time Complexity

// Sorting takes:

// * `O(n log n)`

// # Space Complexity

// Depends on sorting implementation, but commonly:

// * `O(log n)` (recursion stack) or `O(1)` extra space depending on the algorithm.


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0,
            // choose current number as new candidate
            if (count == 0) {
                candidate = num;
            }

            // If current number is same as candidate,
            // increase count
            if (num == candidate) {
                count++;
            }
            // Otherwise decrease count
            else {
                count--;
            }
        }

        // Since the problem guarantees that
        // a majority element always exists,
        // candidate is the answer.
        return candidate;
    }
}


// Core Idea

// Think of this as a voting system:

// Same number as candidate → gets one vote.
// Different number → loses one vote.
// When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// # Dry Run of Boyer-Moore Voting Algorithm (Optimal Approach)

// ## Java Code

// ```java id="q3k0rn"
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0, choose new candidate
            if (count == 0) {
                candidate = num;
            }

            // Same element → increase vote
            if (num == candidate) {
                count++;
            }
            // Different element → decrease vote
            else {
                count--;
            }
        }

        return candidate;
    }
}

// ---

// # Example Input

// ```text id="ab7r6h"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * Majority element appears more than `7/2 = 3` times.
// * `2` appears 4 times.

// ---

// # Core Idea

// Think of this as a voting system:

// * Same number as candidate → gets one vote.
// * Different number → loses one vote.
// * When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// ---

// # Step-by-Step Dry Run

// Initially:

// ```text id="m71l1f"
// candidate = 0
// count = 0
// ```

// ---

// ## Iteration 1: num = 2

// ### count == 0

// Set:

// ```text id="5r6pjo"
// candidate = 2
// ```

// Since `num == candidate`:

// ```text id="owjlwm"
// count = 1
// ```

// ---

// ## Iteration 2: num = 2

// `num == candidate`

// ```text id="p2o0wu"
// count = 2
// ```

// ---

// ## Iteration 3: num = 1

// `num != candidate`

// ```text id="4lh50q"
// count = 1
// ```

// ---

// ## Iteration 4: num = 1

// `num != candidate`

// ```text id="7qns4k"
// count = 0
// ```

// ---

// ## Iteration 5: num = 1

// ### count == 0

// Set:

// ```text id="1m0f0w"
// candidate = 1
// ```

// `num == candidate`

// ```text id="vh70an"
// count = 1
// ```

// ---

// ## Iteration 6: num = 2

// `num != candidate`

// ```text id="6e2o9p"
// count = 0
// ```

// ---

// ## Iteration 7: num = 2

// ### count == 0

// Set:

// ```text id="w6m4uk"
// candidate = 2
// ```

// `num == candidate`

// ```text id="wlm0hv"
// count = 1
// ```

// ---

// # Final Result

// ```text id="sf01sm"
// candidate = 2
// ```

// Return `2`.

// ---

// # Dry Run Table

// | Step | num | count before | Action                       | candidate after | count after |
// | ---: | --: | -----------: | ---------------------------- | --------------: | ----------: |
// |    1 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |
// |    2 |   2 |            1 | Same, increment              |               2 |           2 |
// |    3 |   1 |            2 | Different, decrement         |               2 |           1 |
// |    4 |   1 |            1 | Different, decrement         |               2 |           0 |
// |    5 |   1 |            0 | Set candidate = 1, increment |               1 |           1 |
// |    6 |   2 |            1 | Different, decrement         |               1 |           0 |
// |    7 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |

// Final answer = `2`.

// ---

// # Cancellation Visualization

// ```text id="s5y8qa"
// 2  2  1  1  1  2  2
//    ×  ×  ×
// Remaining majority element = 2
// ```

// Each different element cancels one occurrence of the current candidate.

// ---

// # Why It Works

// The majority element occurs more than all other elements combined, so it cannot be completely canceled out.

// ---

// # Time Complexity

// * `O(n)`

// # Space Complexity

// * `O(1)`

// ---

// # Interview One-Line Explanation

// > Maintain a candidate and a vote count. Increase the count for the same element, decrease it for a different element, and reset the candidate when the count becomes zero. The majority element survives all cancellations.

// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;

//         // Check frequency of every element
//         for (int i = 0; i < n; i++) {
//             int count = 0;

//             // Count how many times nums[i] appears
//             for (int j = 0; j < n; j++) {
//                 if (nums[j] == nums[i]) {
//                     count++;
//                 }
//             }

//             // If frequency is greater than n/2,
//             // nums[i] is the majority element
//             if (count > n / 2) {
//                 return nums[i];
//             }
//         }

//         // Problem guarantees a majority element always exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// We need an element appearing more than 3 times.



// Outer Loop Iteration 1
// i = 0
// nums[i] = 2count = 0
// Now the inner loop counts how many times 2 appears.

// Inner Loop
// jnums[j]Compare with nums[i] = 2count02Equal112Equal221Not Equal231Not Equal241Not Equal252Equal362Equal4
// Final count = 4

// Check Majority Condition
// count = 4n/2 = 3
// Since:
// 4 > 3
// The element 2 is the majority element.
// Return 2.

// Program Stops Here
// No further iterations are needed.

// Final Output
// 2

// Visual Representation
// nums = [2, 2, 1, 1, 1, 2, 2]        ↑      nums[i] = 2
// Occurrences of 2:
// 2, 2, _, _, _, 2, 2
// Total occurrences = 4
// Since 4 > 3, return 2.

// Time Complexity


// Outer loop runs n times.


// Inner loop runs n times.


// Total = O(n²).


// Space Complexity


// Uses only n, i, j, and count.


// Total = O(1).





// // import java.util.HashMap;

// // class Solution {
// //     public int majorityElement(int[] nums) {
// //         HashMap<Integer, Integer> map = new HashMap<>();
// //         int n = nums.length;

//         // Count frequency of each element
//         for (int num : nums) {
//             // Increase count of current number
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             // If count becomes greater than n/2,
//             // this is the majority element
//             if (map.get(num) > n / 2) {
//                 return num;
//             }
//         }

//         // Problem guarantees majority element exists
//         return -1;
//     }
// }



// Example Input
// nums = [2, 2, 1, 1, 1, 2, 2]


// n = 7


// n / 2 = 3


// Need an element appearing more than 3 times.



// Step-by-Step Dry Run
// Initially:
// map = {}

// Iteration 1
// num = 2
// map.put(2, map.getOrDefault(2, 0) + 1);


// map.getOrDefault(2, 0) → 0


// New count = 1


// Map:
// {2=1}
// Check:
// 1 > 3 ? No

// Iteration 2
// num = 2
// Current count = 1
// New count = 2
// Map:
// {2=2}
// Check:
// 2 > 3 ? No

// Iteration 3
// num = 1
// New count = 1
// Map:
// {2=2, 1=1}
// Check:
// 1 > 3 ? No

// Iteration 4
// num = 1
// New count = 2
// Map:
// {2=2, 1=2}
// Check:
// 2 > 3 ? No

// Iteration 5
// num = 1
// New count = 3
// Map:
// {2=2, 1=3}
// Check:
// 3 > 3 ? No
// Remember, majority means strictly greater than n/2.

// Iteration 6
// num = 2
// New count = 3
// Map:
// {2=3, 1=3}
// Check:
// 3 > 3 ? No

// Iteration 7
// num = 2
// New count = 4
// Map:
// {2=4, 1=3}
// Check:
// 4 > 3 ? Yes
// Return 2.

// Final Output
// 2

// How getOrDefault() Works
// map.getOrDefault(num, 0)


// If key exists → returns its current value.


// If key does not exist → returns 0.


// Examples:


// map.getOrDefault(2, 0) → 2


// map.getOrDefault(5, 0) → 0



// Time Complexity
// Each element is processed once.


// Time: O(n)


// Space Complexity
// In the worst case, all elements are distinct.


// Space: O(n)


// import java.util.Arrays;

// class Solution {
//     public int majorityElement(int[] nums) {
//         // Sort the array
//         Arrays.sort(nums);

//         // After sorting, the majority element
//         // will always be at index n/2
//         return nums[nums.length / 2];
//     }
// }

# Dry Run of Sorting Approach

## Java Code

```java id="ttv7bn"
import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Return the middle element
        return nums[nums.length / 2];
    }
}
```

// ---

// ## Example Input

// ```text id="9kz2r6"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * `n / 2 = 3`

// ---

// # Step 1: Sort the Array

// Before sorting:

// ```text id="qebrb2"
// [2, 2, 1, 1, 1, 2, 2]
// ```

// After sorting:

// ```text id="y9kzrz"
// [1, 1, 1, 2, 2, 2, 2]
// ```

// ---

// # Step 2: Find Middle Index

// ```java id="yr7jyl"
// nums.length / 2 = 7 / 2 = 3
// ```

// Middle index = `3`

// ---

// # Step 3: Return Element at Index 3

// Sorted array with indices:

// | Index |  0 |  1 |  2 |  3 |  4 |  5 |  6 |
// | ----: | -: | -: | -: | -: | -: | -: | -: |
// | Value |  1 |  1 |  1 |  2 |  2 |  2 |  2 |

// ```text id="j3hr3l"
// nums[3] = 2
// ```

// Return `2`.

// ---

// # Why Middle Element Is Always the Majority

// The majority element appears more than `n/2` times, so it must occupy the middle position after sorting.

// For this example:

// ```text id="1o0p7r"
// [1, 1, 1, 2, 2, 2, 2]
//           ↑
//        middle element
// ```

// Since `2` occurs 4 times (more than 3), it covers the middle index.

// ---

// # Final Output

// ```text id="sm11rm"
// 2
// ```

// ---

// # Another Example

// Input:

// ```text id="nwr67v"
// [3, 2, 3]
// ```

// Sorted:

// ```text id="1mn91l"
// [2, 3, 3]
// ```

// * `n = 3`
// * `n / 2 = 1`

// ```text id="1ln7f5"
// nums[1] = 3
// ```

// Return `3`.

// ---

// # Time Complexity

// Sorting takes:

// * `O(n log n)`

// # Space Complexity

// Depends on sorting implementation, but commonly:

// * `O(log n)` (recursion stack) or `O(1)` extra space depending on the algorithm.


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0,
            // choose current number as new candidate
            if (count == 0) {
                candidate = num;
            }

            // If current number is same as candidate,
            // increase count
            if (num == candidate) {
                count++;
            }
            // Otherwise decrease count
            else {
                count--;
            }
        }

        // Since the problem guarantees that
        // a majority element always exists,
        // candidate is the answer.
        return candidate;
    }
}


// Core Idea

// Think of this as a voting system:

// Same number as candidate → gets one vote.
// Different number → loses one vote.
// When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// # Dry Run of Boyer-Moore Voting Algorithm (Optimal Approach)

// ## Java Code

// ```java id="q3k0rn"
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // Possible majority element
        int count = 0;     // Vote count

        for (int num : nums) {
            // If count becomes 0, choose new candidate
            if (count == 0) {
                candidate = num;
            }

            // Same element → increase vote
            if (num == candidate) {
                count++;
            }
            // Different element → decrease vote
            else {
                count--;
            }
        }

        return candidate;
    }
}

// ---

// # Example Input

// ```text id="ab7r6h"
// nums = [2, 2, 1, 1, 1, 2, 2]
// ```

// * `n = 7`
// * Majority element appears more than `7/2 = 3` times.
// * `2` appears 4 times.

// ---

// # Core Idea

// Think of this as a voting system:

// * Same number as candidate → gets one vote.
// * Different number → loses one vote.
// * When votes become zero, choose a new candidate.

// Because the majority element appears more than half the time, it will survive all cancellations.

// ---

// # Step-by-Step Dry Run

// Initially:

// ```text id="m71l1f"
// candidate = 0
// count = 0
// ```

// ---

// ## Iteration 1: num = 2

// ### count == 0

// Set:

// ```text id="5r6pjo"
// candidate = 2
// ```

// Since `num == candidate`:

// ```text id="owjlwm"
// count = 1
// ```

// ---

// ## Iteration 2: num = 2

// `num == candidate`

// ```text id="p2o0wu"
// count = 2
// ```

// ---

// ## Iteration 3: num = 1

// `num != candidate`

// ```text id="4lh50q"
// count = 1
// ```

// ---

// ## Iteration 4: num = 1

// `num != candidate`

// ```text id="7qns4k"
// count = 0
// ```

// ---

// ## Iteration 5: num = 1

// ### count == 0

// Set:

// ```text id="1m0f0w"
// candidate = 1
// ```

// `num == candidate`

// ```text id="vh70an"
// count = 1
// ```

// ---

// ## Iteration 6: num = 2

// `num != candidate`

// ```text id="6e2o9p"
// count = 0
// ```

// ---

// ## Iteration 7: num = 2

// ### count == 0

// Set:

// ```text id="w6m4uk"
// candidate = 2
// ```

// `num == candidate`

// ```text id="wlm0hv"
// count = 1
// ```

// ---

// # Final Result

// ```text id="sf01sm"
// candidate = 2
// ```

// Return `2`.

// ---

// # Dry Run Table

// | Step | num | count before | Action                       | candidate after | count after |
// | ---: | --: | -----------: | ---------------------------- | --------------: | ----------: |
// |    1 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |
// |    2 |   2 |            1 | Same, increment              |               2 |           2 |
// |    3 |   1 |            2 | Different, decrement         |               2 |           1 |
// |    4 |   1 |            1 | Different, decrement         |               2 |           0 |
// |    5 |   1 |            0 | Set candidate = 1, increment |               1 |           1 |
// |    6 |   2 |            1 | Different, decrement         |               1 |           0 |
// |    7 |   2 |            0 | Set candidate = 2, increment |               2 |           1 |

// Final answer = `2`.

// ---

// # Cancellation Visualization

// ```text id="s5y8qa"
// 2  2  1  1  1  2  2
//    ×  ×  ×
// Remaining majority element = 2
// ```

// Each different element cancels one occurrence of the current candidate.

// ---

// # Why It Works

// The majority element occurs more than all other elements combined, so it cannot be completely canceled out.

// ---

// # Time Complexity

// * `O(n)`

// # Space Complexity

// * `O(1)`

// ---

// # Interview One-Line Explanation

// > Maintain a candidate and a vote count. Increase the count for the same element, decrease it for a different element, and reset the candidate when the count becomes zero. The majority element survives all cancellations.


