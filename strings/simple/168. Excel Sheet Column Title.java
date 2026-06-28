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

// 168. Excel Sheet Column Title
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

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

// Input: columnNumber = 1
// Output: "A"
// Example 2:

// Input: columnNumber = 28
// Output: "AB"
// Example 3:

// Input: columnNumber = 701
// Output: "ZY"

//algorithm 
// while(columnNumber > 0):

//     columnNumber--

//     remainder = columnNumber % 26, select the last digit from whole no

//     convert remainder to letter

//     columnNumber = columnNumber / 26 , removes that last didgit which is proccessed above and converted

class Solution {
    public String convertToTitle(int columnNumber) {

        // This variable stores the remainder after dividing by 26
        // It helps us find which letter (A-Z) we need
        int remainder = 0;

        // This string will store our final answer
        // Example:
        // 28 -> "AB"
        String ans = "";

        // Continue until the whole number is converted
        while (columnNumber > 0) {

            // Excel columns start from 1:
            // A = 1
            // B = 2
            // ...
            // Z = 26
            //
            // But programming indexes start from 0:
            // A = 0
            // B = 1
            // ...
            //
            // So we subtract 1 to convert Excel value into 0-based index
            //
            // Example:
            // 1 -> 0 (A)
            // 2 -> 1 (B)
            // 26 -> 25 (Z)
            columnNumber--;

            // Find the current character position
            //
            // The remainder will always be between 0 and 25
            //
            // Mapping:
            // 0 -> A
            // 1 -> B
            // 2 -> C
            // ...
            // 25 -> Z
            remainder = columnNumber % 26;

            // Convert number position into a character
            //
            // ASCII values:
            // A = 65
            // B = 66
            // C = 67
            //
            // Example:
            //
            // remainder = 0
            //
            // 'A' + 0
            // 65 + 0 = 65
            // (char)65 = 'A'
            //
            //
            // remainder = 1
            //
            // 'A' + 1
            // 65 + 1 = 66
            // (char)66 = 'B'
            //
            // So:
            // remainder becomes the movement from A
            char ch = (char) ('A' + remainder);

            // Add the character at the beginning of answer
            //
            // Why at beginning?
            //
            // Because we calculate letters from right to left
            //
            // Example:
            // 28:
            //
            // First we get B
            // ans = "B"
            //
            // Then we get A
            // ans = "A" + "B"
            //
            // Result = "AB"
            ans = ch + ans;

            // Move to the next left position
            //
            // Example:
            // 28
            //
            // After finding B:
            // columnNumber = 27
            //
            // 27 / 26 = 1
            //
            // Now we process 1 to get A
            columnNumber = columnNumber / 26;
        }

        // Return final Excel column title
        return ans;
    }
}

// give example of 28

// Let's dry run 28 → AB and understand this line:

// char ch = (char)('A' + remainder);
// Initial:
// columnNumber = 28
// ans = ""
// First loop
// Step 1: Decrease number
// columnNumber--;

// Now:

// 28 - 1 = 27
// Step 2: Find remainder
// remainder = columnNumber % 26;

// Calculation:

// 27 % 26 = 1

// So:

// remainder = 1
// Step 3: Convert remainder to character

// Code:

// char ch = (char)('A' + remainder);

// Put value:

// 'A' + 1

// ASCII values:

// 'A' = 65

// So:

// 65 + 1 = 66

// Convert 66 back to character:

// (char)66 = 'B'

// So:

// ch = 'B'

// Add:

// ans = ch + ans;

// Now:

// ans = "B"
// Step 4: Divide
// columnNumber = columnNumber / 26;
// 27 / 26 = 1

// Now:

// columnNumber = 1
// Second loop
// Step 1:
// columnNumber--;
// 1 - 1 = 0
// Step 2:
// remainder = 0 % 26;
// remainder = 0
// Step 3:
// char ch = (char)('A' + remainder);

// Put value:

// 'A' + 0

// ASCII:

// 65 + 0 = 65

// Convert:

// (char)65 = 'A'

// So:

// ch = 'A'

// Add in front:

// ans = ch + ans;

// Now:

// ans = "A" + "B"

// Result:

// ans = "AB"
// Step 4:
// columnNumber = 0 / 26;
// columnNumber = 0

// Loop stops.

// Final:

// 28 → AB

// So the important part:

// (char)('A' + remainder)

// worked like:

// remainder = 1

// 'A' + 1

// A → move one step forward

// A B
// ↑

// Result = B

// That is how numbers 0-25 become letters A-Z.