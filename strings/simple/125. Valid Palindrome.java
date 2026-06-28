
// Code
// Code
// Testcase
// Testcase
// Test Result
// 125. Valid Palindrome
// Easy
// Topics
// premium lock icon
// Companies
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
// Example 3:

// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.

// class Solution {
//     public boolean isPalindrome(String s) {

//         StringBuilder new_one = new StringBuilder();

//         for(int i = 0; i < s.length(); i++) {

//             if(Character.isLetterOrDigit(s.charAt(i))) {

//                 new_one.append(
//                     Character.toLowerCase(s.charAt(i))
//                 );
//             }
//         }

//         StringBuilder rev = new StringBuilder();

//         int j = new_one.length() - 1;

//         while(j >= 0) {
//             rev.append(new_one.charAt(j));
//             j--;
//         }

//         return new_one.toString().equals(rev.toString());
//     }
// }

class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

// Keep two pointers at both ends, skip non-alphanumeric characters, compare
// lowercase characters, and move inward until a mismatch is found or the
// pointers cross.

// Idea

// A palindrome reads the same from both ends.

// Example:

// "A man, a plan, a canal: Panama"

// After removing special characters and converting to lowercase:

// amanaplanacanalpanama

// Now compare:

// a == a
// m == m
// a == a
// ...

// Instead of creating a new string, we use two pointers:

// left starts from the beginning.
// right starts from the end.
// Skip non-alphanumeric characters.
// Compare characters after converting them to lowercase.
// Code
// class Solution {
// public boolean isPalindrome(String s) {

// int left = 0;
// int right = s.length() - 1;

// while(left < right) {

// while(left < right &&
// !Character.isLetterOrDigit(s.charAt(left))) {
// left++;
// }

// while(left < right &&
// !Character.isLetterOrDigit(s.charAt(right))) {
// right--;
// }

// if(Character.toLowerCase(s.charAt(left))
// != Character.toLowerCase(s.charAt(right))) {
// return false;
// }

// left++;
// right--;
// }

// return true;
// }
// }
// Dry Run

// Input:

// s = "A man, a plan, a canal: Panama"

// Initial:

// left = 0 -> 'A'
// right = 29 -> 'a'
// Iteration 1
// Character.toLowerCase('A')

// gives:

// 'a'

// Compare:

// 'a' == 'a'

// ✅ Match

// Move pointers:

// left++
// right--
// Iteration 2
// left -> ' '
// right -> 'm'

// Space is not alphanumeric.

// This loop runs:

// while(!Character.isLetterOrDigit(s.charAt(left)))
// {
// left++;
// }

// Skip space.

// left -> 'm'

// Compare:

// 'm' == 'm'

// ✅ Match

// Move both pointers.

// Iteration 3
// left -> 'a'
// right -> 'a'

// ✅ Match

// Move both pointers.

// The process continues:

// a == a
// n == n
// a == a
// p == p
// ...

// All characters match.

// Eventually:

// left >= right

// Loop stops.

// Return:

// true
// What these loops do
// Skip special characters from left
// while(left < right &&
// !Character.isLetterOrDigit(s.charAt(left))) {
// left++;
// }

// Example:

// left -> ','

// Comma is not a letter or digit.

// Move:

// left++

// until we find:

// a-z, A-Z, 0-9
// Skip special characters from right
// while(left < right &&
// !Character.isLetterOrDigit(s.charAt(right))) {
// right--;
// }

// Example:

// right -> ':'

// Skip it.

// Why Character.toLowerCase()?

// Example:

// 'A' and 'a'

// Without lowercase:

// 'A' != 'a'

// With lowercase:

// Character.toLowerCase('A')

// becomes:

// 'a'

// Now:

// 'a' == 'a'

// ✅ Match

// Why return false immediately?
// if(Character.toLowerCase(s.charAt(left))
// != Character.toLowerCase(s.charAt(right))) {
// return false;
// }

// Example:

// raceacar

// Compare:

// r == r
// a == a
// c != a

// As soon as one pair doesn't match, it can never be a palindrome.

// So:

// return false;
// Algorithm (Interview Answer)
// 1. Initialize two pointers:
// left = 0, right = n-1.

// 2. While left < right:
// - Skip non-alphanumeric characters from the left.
// - Skip non-alphanumeric characters from the right.
// - Convert both characters to lowercase and compare.
// - If they differ, return false.
// - Otherwise move both pointers inward.

// 3. If all comparisons succeed, return true.
// Complexity
// Time : O(n)
// Space : O(1)

// because each character is visited at most once and no extra string is
// created.

// dry run the code

// Let's dry run the two-pointer solution on:

// s = "A man, a plan, a canal: Panama"
// Initial Values
// left = 0 -> 'A'
// right = 29 -> 'a'
// Iteration 1

// Skip special characters?

// 'A' is alphanumeric -> No
// 'a' is alphanumeric -> No

// Compare:

// Character.toLowerCase('A') = 'a'
// Character.toLowerCase('a') = 'a'
// 'a' == 'a' ✓

// Move:

// left = 1
// right = 28
// Iteration 2
// left = 1 -> ' '

// Space is not alphanumeric.

// Run:

// left++;

// Now:

// left = 2 -> 'm'
// right = 28 -> 'm'

// Compare:

// 'm' == 'm' ✓

// Move:

// left = 3
// right = 27
// Iteration 3
// left = 3 -> 'a'
// right = 27 -> 'a'

// Compare:

// 'a' == 'a' ✓

// Move:

// left = 4
// right = 26
// Iteration 4
// left = 4 -> 'n'
// right = 26 -> 'n'

// Compare:

// 'n' == 'n' ✓

// Move:

// left = 5
// right = 25
// Iteration 5
// left = 5 -> ','

// Skip comma:

// left = 6 -> ' '
// left = 7 -> 'a'
// right = 25 -> 'a'

// Compare:

// 'a' == 'a' ✓

// Move:

// left = 8
// right = 24
// Iteration 6
// left = 8 -> ' '

// Skip space:

// left = 9 -> 'p'
// right = 24 -> 'm'

// Skip from right:

// right = 23 -> 'a'
// right = 22 -> 'n'
// right = 21 -> 'a'
// right = 20 -> 'P'

// Compare:

// 'p' == Character.toLowerCase('P')
// 'p' == 'p' ✓

// Move:

// left = 10
// right = 19
// Remaining Comparisons
// l == l ✓
// a == a ✓
// n == n ✓
// a == a ✓
// c == c ✓
// a == a ✓
// n == n ✓
// a == a ✓
// l == l ✓
// p == p ✓
// a == a ✓
// n == n ✓
// a == a ✓
// m == m ✓
// a == a ✓

// All pairs match.

// Eventually:

// left >= right

// Loop stops.

// Why does it work?

// At every step:

// while(left < right &&
// !Character.isLetterOrDigit(s.charAt(left)))
// {
// left++;
// }

// skips:

// ' '
// ','
// ':'

// and

// Character.toLowerCase(...)

// makes:

// 'A' -> 'a'
// 'P' -> 'p'

// so comparisons become case-insensitive.

// Example that returns false
// s = "race a car"

// After skipping spaces:

// r == r ✓
// a == a ✓
// c != a ✗

// The code executes:

// return false;

// immediately.
