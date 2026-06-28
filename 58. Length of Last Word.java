class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1; // stores length of string and keep i at last position of string

        // remove last spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // count characters from last position of string until the space occurs
        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }
}

// Line-by-Line Explanation
// Method Declaration
// public int lengthOfLastWord(String s)
// Takes a string s.
// Returns the length of the last word.
// Start From End
// int i = s.length() - 1;

// If:

// s = "Hello World"

// Length:

// 11

// Last index:

// 10

// So:

// i = 10;

// Pointing at:

// Hello World
// ↑
// i
// Skip Trailing Spaces
// while (i >= 0 && s.charAt(i) == ' ') {
// i--;
// }

// Purpose:

// If the string ends with spaces:

// "moon "

// Move left until reaching a letter.

// Example:

// moon___
// ↑

// (_ represents space)

// i--;

// keeps moving left.

// After loop:

// moon
// ↑

// Now i points to the last character of the last word.

// Initialize Counter
// int count = 0;

// Stores the length of the last word.

// Count Last Word Characters
// while (i >= 0 && s.charAt(i) != ' ') {

// Continue while:

// Index is valid.
// Current character is NOT a space.
// Increase Count
// count++;

// Count one character.

// Move Left
// i--;

// Go to previous character.

// Return Answer
// return count;

// Return the length of the last word.

// Complete Dry Run
// Input
// s = "Hello World"
// Initial State
// i = s.length()-1
// i = 10

// String:

// H e l l o _ W o r l d
// 0 1 2 3 4 5 6 7 8 9 10
// ↑
// i
// First While Loop
// while(i>=0 && s.charAt(i)==' ')

// Check:

// s.charAt(10)
// 'd'

// Is it a space?

// No

// Loop does not execute.

// Count Initialization
// count = 0
// Second While Loop
// Iteration 1

// Current:

// d

// Condition:

// i>=0 && 'd'!=' '

// True.

// count++;
// count = 1
// i--;
// i = 9
// Iteration 2

// Current:

// l
// count = 2
// i = 8
// Iteration 3

// Current:

// r
// count = 3
// i = 7
// Iteration 4

// Current:

// o
// count = 4
// i = 6
// Iteration 5

// Current:

// W
// count = 5
// i = 5
// Iteration 6

// Current:

// space

// Condition:

// s.charAt(5)!=' '

// becomes:

// ' '!=' '

// False.

// Loop stops.

// Return
// return count;
// return 5

// Output:

// 5
// Dry Run Example 2

// Input:

// s = " fly me to the moon "
// Step 1: Skip Spaces

// Start:

// " fly me to the moon "
// ↑

// Skip:

// space
// space

// Now:

// " fly me to the moon"
// ↑
// n
// Step 2: Count

// Count:

// n → 1
// o → 2
// o → 3
// m → 4

// Next character:

// space

// Stop.

// Return:

// 4
// Interview Explanation

// Approach:

// Start from the end of the string.
// Skip trailing spaces.
// Count characters until a space is found.
// The count represents the length of the last word.

// Time Complexity: O(n)

// Space Complexity: O(1)

// Where n is the length of the string.