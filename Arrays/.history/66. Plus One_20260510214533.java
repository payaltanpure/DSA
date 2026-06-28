// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

// Increment the large integer by one and return the resulting array of digits.

 

// Example 1:

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].
// Example 2:

// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
// Incrementing by one gives 4321 + 1 = 4322.
// Thus, the result should be [4,3,2,2].
// Example 3:

// Input: digits = [9]
// Output: [1,0]
// Explanation: The array represents the integer 9.
// Incrementing by one gives 9 + 1 = 10.
// Thus, the result should be [1,0].


class Solution {
    public int[] plusOne(int[] digits) {
        for(int i= digits.length-1; i>=0;i-- )
        //    fetches last digit from digits array
        {
            if(digits[i]<9) //if digit less than 9 take it as it is and add it to previous digit
            {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }

        int[] result = new int[digits.length+1];
        result[0]= 1;
        return result;
    }
}


// Problem Statement

// You are given an integer represented as an array.

// Example:

// digits = [1, 2, 3]

// This represents the number:

// 123

// You need to add 1 and return the resulting array.

// Examples
// Example 1
// digits = [1,2,3]

// Output:

// [1,2,4]
// Example 2
// digits = [4,3,2,1]

// Output:

// [4,3,2,2]
// Example 3
// digits = [9]

// Output:

// [1,0]
// Core Idea

// Addition starts from the last digit (units place).

// If digit < 9 → just add 1 and return.
// If digit = 9 → it becomes 0 and carries 1 to the previous digit.
// If all digits are 9 → create a new array with one extra digit.
// Step-by-Step Explanation
// Traverse from Right to Left
// for (int i = digits.length - 1; i >= 0; i--)

// We start from the last digit.

// Case 1: Digit Less Than 9
// if (digits[i] < 9) {
//     digits[i]++;
//     return digits;
// }

// If the digit is 0 to 8:

// Increment it.
// No carry is needed.
// Return immediately.
// Example
// [1,2,3]

// Last digit = 3

// After increment:

// [1,2,4]
// Case 2: Digit is 9
// digits[i] = 0;

// Because:

// 9 + 1 = 10

// Store 0 and carry 1 to the next digit.

// What Happens If All Digits Are 9?

// Example:

// [9,9,9]

// After the loop:

// [0,0,0]

// We still have a carry, so create a new array.

// Create New Array
// int[] result = new int[digits.length + 1];
// result[0] = 1;
// return result;

// For [9,9,9]:

// [1,0,0,0]
// Dry Run 1: [1,2,3]
// Start from index 2.
// digits[2] = 3 < 9
// Increment to 4.
// Return [1,2,4]
// Dry Run 2: [1,2,9]
// i = 2

// 9

// Set to 0 → [1,2,0]

// i = 1

// 2 < 9

// Increment to 3 → [1,3,0]

// Return.

// Dry Run 3: [9,9,9]
// i = 2

// → [9,9,0]

// i = 1

// → [9,0,0]

// i = 0

// → [0,0,0]

// Create new array:

// [1,0,0,0]
// Why Return Early?

// As soon as one digit can be incremented, no further carry is needed.

// So we return immediately.

// Time Complexity
// Complexity	Value
// Time	O(n)
// Space	O(1) normally, O(n) only when all digits are 9
// Space Complexity
// Usually modifies the same array.
// Creates a new array only in the all-9 case.
// Visual Representation
// digits = [1, 2, 9]

//           ↑
//           9 + 1 = 10
//           write 0, carry 1

// digits = [1, 2, 0]

//        ↑
//        2 + 1 = 3

// digits = [1, 3, 0]
// Brute Force Approach (Commented Code)

// Your commented code:

// Converts array to a number.
// Adds 1.
// Converts back to string.
// Converts string to array.
// Why It Is Not Ideal
// Can overflow for large numbers.
// Uses extra space.
// Slower.

// LeetCode may provide arrays with hundreds of digits, which do not fit in long.

// Example of Overflow
// digits = [9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9]

// This value is larger than Java long.

// Viva Questions and Answers
// 1. Why do we start from the last index?

// Because addition starts from the units place.

// 2. Why check digits[i] < 9?

// If true, incrementing does not create a carry.

// 3. Why set digit to 0 when it is 9?

// Because 9 + 1 = 10.

// 4. Why create a new array?

// When all digits are 9.

// 5. What is the time complexity?

// O(n)

// 6. Why is the brute-force approach not recommended?

// It may overflow and is less efficient.

//brute force 
// long number = 0;

//         // convert array to number
//         for (int i = 0; i < digits.length; i++) {
//             number = number * 10 + digits[i];
//         }

//         // add one
//         number = number + 1;

//         // convert number to string to get length
//         String str = String.valueOf(number);

//         int[] digits1 = new int[str.length()];

//         // convert string back to array
//         for (int i = 0; i < str.length(); i++) {
//             digits1[i] = str.charAt(i)-'0' ;
//         }

//         return digits1;