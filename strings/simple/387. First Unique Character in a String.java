// 387. First Unique Character in a String
// Easy
// Topics
// premium lock icon
// Companies
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:

// Input: s = "leetcode"

// Output: 0

// Explanation:

// The character 'l' at index 0 is the first character that does not occur at any other index.

// Example 2:

// Input: s = "loveleetcode"

// Output: 2

// Example 3:

// Input: s = "aabb"

// Output: -1

class Solution {

    public int firstUniqChar(String s) {

        // Frequency array to store the count of each letter.
        // Index 0 -> a
        // Index 1 -> b
        // ...
        // Index 25 -> z
        int[] count = new int[26];

        // -----------------------------
        // Pass 1: Count the frequency
        // -----------------------------
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Convert character to array index.
            int index = ch - 'a';

            // Increase frequency.
            count[index]++;
        }

        // ------------------------------------
        // Pass 2: Find first unique character
        // ------------------------------------
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            int index = ch - 'a';

            // If frequency is exactly 1,
            // this is the first non-repeating character.
            if (count[index] == 1) {

                // Return its position in the string,
                // not its alphabet index.
                return i;
            }
        }

        // No unique character exists.
        return -1;
    }
}

// Time Complexity
// First pass (count frequencies): O(n)
// Second pass (find first unique): O(n)

// Overall: O(n)

// Space Complexity
// Frequency array of size 26: O(1) (constant space)

// Initial State

// String

// loveleetcode

// Indexes

// Index : 0 1 2 3 4 5 6 7 8 9 10 11

// Char : l o v e l e e t c o d e

// Frequency array

// a b c d e f g h i j k l m n o p q r s t u v w x y z

// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// PASS 1 – Count Frequencies
// Iteration 1
// i = 0

// Character = 'l'

// Index = 'l' - 'a'

// 108 - 97

// = 11

// Increase

// count[11]++
// l = 1
// Iteration 2
// i = 1

// Character = 'o'

// Index = 14

// Increase

// o = 1
// Iteration 3
// i = 2

// Character = 'v'

// Index = 21

// Increase

// v = 1
// Iteration 4
// i = 3

// Character = 'e'

// Index = 4

// Increase

// e = 1
// Iteration 5
// i = 4

// Character = 'l'

// Increase

// l = 2
// Iteration 6
// i = 5

// Character = 'e'

// Increase

// e = 2
// Iteration 7
// i = 6

// Character = 'e'

// Increase

// e = 3
// Iteration 8
// i = 7

// Character = 't'

// Increase

// t = 1
// Iteration 9
// i = 8

// Character = 'c'

// Increase

// c = 1
// Iteration 10
// i = 9

// Character = 'o'

// Increase

// o = 2
// Iteration 11
// i = 10

// Character = 'd'

// Increase

// d = 1
// Iteration 12
// i = 11

// Character = 'e'

// Increase

// e = 4
// Frequency Array After Pass 1
// Letter Frequency
// c 1
// d 1
// e 4
// l 2
// o 2
// t 1
// v 1

// All other letters have frequency 0.

// Notice something important:

// The frequency array does not know which unique character comes first. It only
// knows how many times each letter appears.

// For example:

// c → 1
// v → 1
// t → 1
// d → 1

// All are unique, but which one appears first in the string?

// The frequency array cannot answer that.

// That's why we need Pass 2.

// PASS 2 – Find the First Unique Character

// We scan the original string from left to right.

// Iteration 1
// i = 0

// Character = l

// Frequency = 2
// Not unique

// Skip
// Iteration 2
// i = 1

// Character = o

// Frequency = 2
// Not unique

// Skip
// Iteration 3
// i = 2

// Character = v

// Frequency = 1
// Unique character found!

// Return

// return 2;

// The loop stops immediately.

// Why Don't We Return 'c'?

// Some students think:

// Frequency array says

// c = 1

// So return c.

// But the problem asks for the first unique character in the string, not the
// alphabetically first unique letter.

// Look at the string again:

// Index : 0 1 2 3 4 5 6 7 8 9 10 11

// Char : l o v e l e e t c o d e

// Unique characters are:

// Character String Index
// v 2
// t 7
// c 8
// d 10

// The first one encountered while scanning the string is 'v' at index 2.

// Final Answer
// Pass 1
// ↓

// Count every character

// ↓

// Pass 2
// ↓

// Traverse the string again

// ↓

// l → count = 2 → Skip

// o → count = 2 → Skip

// v → count = 1 → Return 2
// Key Idea to Remember
// Pass 1 answers: "How many times does each character appear?"
// Pass 2 answers: "Among the characters in their original order, which is the
// first one whose count is 1?"