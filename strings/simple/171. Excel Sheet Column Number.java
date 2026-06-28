// Excel columns start from 1:
// A = 1
// B = 2
// ...
// Z = 26
//
// But programming indexes start from 0:
// A = 0
// B = 1

//ascii values and excel column values are interrelated 

// 171. Excel Sheet Column Number
// Easy
// Topics
// premium lock icon
// Companies
// Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...

// Example 1:

// Input: columnTitle = "A"
// Output: 1
// Example 2:

// Input: columnTitle = "AB"
// Output: 28
// Example 3:

// Input: columnTitle = "ZY"
// Output: 701

// Great. Since you understand the concept, let's focus only on algorithm + code + dry run.

// Algorithm (Excel Column Title → Number)
// Steps:
// Initialize result = 0
// Traverse each character of the string from left to right

// Convert character into its Excel value:

// value = character - 'A' + 1

// Update result:

// result = result * 26 + value
// Return result
// Code (Java)
// class Solution {
//     public int titleToNumber(String columnTitle) {

//         int result = 0;

//         for(int i = 0; i < columnTitle.length(); i++)
//         {
//             char ch = columnTitle.charAt(i);

//             int value = ch - 'A' + 1;

//             result = result * 26 + value;
//         }

//         return result;
//     }
// }
// Dry Run 1

// Input:

// columnTitle = "A"
// Initial
// result = 0

// Loop:

// Character:

// ch = 'A'

// Find value:

// value = 'A' - 'A' + 1

// ASCII:

// 65 - 65 + 1
// = 1

// So:

// value = 1

// Update result:

// result = result * 26 + value

// result = 0 * 26 + 1

// result = 1

// Return:

// 1
// Dry Run 2

// Input:

// columnTitle = "AB"

// Initial:

// result = 0
// Iteration 1

// Character:

// A

// Value:

// A = 1

// Formula:

// result = result*26 + value

// Calculation:

// result = 0*26 + 1

// result = 1

// Now:

// result = 1
// Iteration 2

// Character:

// B

// Value:

// B = 2

// Formula:

// result = 1*26 + 2

// Calculation:

// 26 + 2

// = 28

// Now:

// result = 28

// Return:

// 28
// Dry Run 3

// Input:

// columnTitle = "ZY"

// Initial:

// result = 0
// Iteration 1

// Character:

// Z

// Value:

// Z = 26

// Formula:

// result = 0*26 + 26

// Result:

// 26
// Iteration 2

// Character:

// Y

// Value:

// Y = 25

// Formula:

// result = 26*26 + 25

// Calculation:

// 676 + 25

// = 701

// Return:

// 701
// Visual formula

// For any Excel title:

// ABC

// Calculation:

// A*26² + B*26¹ + C*26⁰

// Example:

// AB

// A*26 + B

// 1*26 + 2

// = 28

// Time Complexity:

// O(n)

// because we visit each character once.

// Space Complexity:

// O(1)

// because we only use one variable.

// how this two formulas work tell me 

// You are asking about these two formulas:

// Character → Excel value
// int value = ch - 'A' + 1;
// Building final answer
// result = result * 26 + value;

// Let's understand both from the base.

// Formula 1:
// int value = ch - 'A' + 1;

// Purpose:

// Convert:

// Letter → Excel number

// Because Excel says:

// A = 1
// B = 2
// C = 3
// ...
// Z = 26
// Why ch - 'A'?

// Characters have ASCII values.

// A = 65
// B = 66
// C = 67
// D = 68
// ...
// Z = 90

// Now suppose:

// ch = 'A'

// Calculation:

// ch - 'A'

// means:

// 65 - 65

// Result:

// 0

// But Excel wants:

// A = 1

// So we add 1:

// 0 + 1 = 1

// Therefore:

// A = 1

// For B:

// ch = 'B'

// ASCII:

// B = 66
// A = 65

// Calculation:

// 'B' - 'A' + 1

// 66 - 65 + 1

// 1 + 1

// 2

// So:

// B = 2

// For Z:

// Z = 90
// A = 65

// Calculation:

// 90 - 65 + 1

// 25 + 1

// 26

// So:

// Z = 26

// So this formula creates:

// A → 1
// B → 2
// C → 3
// ...
// Z → 26
// Formula 2:
// result = result * 26 + value;

// This is the important one.

// It is used because Excel columns are base 26 numbers.

// Like decimal:

// 123

// = 1*100 + 2*10 + 3

// Because each position has power of 10.

// Excel:

// AB

// has base 26.

// Positions:

// A  B

// 26 1

// So:

// AB = A*26 + B

// Values:

// A = 1
// B = 2

// Calculation:

// 1*26 + 2

// 26 + 2

// 28

// Now see how code does it.

// Input:

// AB

// Start:

// result = 0
// First character A

// Convert:

// A = 1

// Apply:

// result = result * 26 + value;

// Substitute:

// result = 0*26 + 1

// Calculate:

// result = 1

// Now result has:

// A
// Second character B

// Convert:

// B = 2

// Apply:

// result = 1*26 + 2

// Why multiply by 26?

// Because we are moving A to the next position.

// Before:

// A

// After adding B:

// AB

// A must become:

// A * 26

// Calculation:

// 1*26 + 2

// 26 + 2

// 28

// Answer:

// AB = 28
// Example ZY

// Input:

// ZY

// Start:

// result = 0

// Z:

// Value:

// Z = 26

// Formula:

// result = 0*26 + 26

// Result:

// 26

// Y:

// Value:

// Y = 25

// Formula:

// result = 26*26 + 25

// Why 26*26?

// Because Z is moving one position left.

// Calculation:

// 676 + 25

// 701

// So:

// ZY = 701
// Final memory:
// Formula 1:
// ch - 'A' + 1

// means:

// Convert letter into Excel number

// Example:

// A → 1
// B → 2
// Z → 26
// Formula 2:
// result = result * 26 + value

// means:

// Shift previous letters left and add new letter

// Example:

// A

// becomes

// A_  (move left)

// A*26

// then add B

// So:

// AB = 1*26 + 2 = 28

// These two formulas together solve the whole problem.
class Solution {
    public int titleToNumber(String columnTitle) {

        // This variable will store the final Excel column number
        // Example: AB -> 28
        int result = 0;

        // Traverse every character of the column title
        // Example: "AB" -> first A, then B
        for (int i = 0; i < columnTitle.length(); i++) {

            // Get the current character
            // First loop: A
            // Second loop: B
            char ch = columnTitle.charAt(i);

            // Convert character into Excel number value
            //
            // ASCII:
            // A = 65
            // B = 66
            //
            // For A:
            // 'A' - 'A' + 1
            // 65 - 65 + 1 = 1
            //
            // For B:
            // 'B' - 'A' + 1
            // 66 - 65 + 1 = 2
            //
            // So:
            // A -> 1
            // B -> 2
            // Z -> 26
            int value = ch - 'A' + 1;

            // Build the answer
            //
            // Excel works like base 26
            //
            // Example: AB
            //
            // First A:
            // result = 0*26 + 1
            // result = 1
            //
            // Then B:
            // result = 1*26 + 2
            // result = 28
            //
            // Multiplying by 26 shifts the previous letters
            // to the left position
            result = result * 26 + value;

            // shift resukt into left and add value into it to get whole no result
        }

        // Return the final Excel column number
        return result;
    }
}