// 392. Is Subsequence
// Easy
// Topics
// premium lock icon
// Companies
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false

// No. A frequency array is not the right approach for this problem.

// This problem is about order of characters, not just their frequency.

// Why doesn't a frequency array work?

// A frequency array only tells you:

// "How many times does each character appear?"

// It does not tell you the order in which the characters appear.

// But this problem says:

// A subsequence must keep the relative order of the characters.

// So the order is very important.

class Solution {

    public boolean isSubsequence(String s, String t) {

        int i = 0; // Pointer for s
        int j = 0; // Pointer for t

        while (i < s.length() && j < t.length()) {

            // If characters match,
            // move both pointers.
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            // Always move pointer of t.
            j++;
        }

        // If we have matched every character of s,
        // then s is a subsequence of t.
        return i == s.length();
        // The expression

        // i == s.length()

        // returns either

        // true

        // or

        // false
    }
}