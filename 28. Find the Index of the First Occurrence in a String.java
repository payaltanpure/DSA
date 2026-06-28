// class Solution {
//     public int strStr(String haystack, String needle) {

//         for (int i = 0; i <= haystack.length() - needle.length(); i++) {

//             // i scans haystack string and maintains the
//             // starting position of needle in haystack

//             int j = 0; // j scans needle string

//             while (j < needle.length() &&
//                    haystack.charAt(i + j) == needle.charAt(j)) {

//                 j++;

//                 // If characters match in both strings,
//                 // keep moving j forward.
//                 // On first mismatch, loop stops.
//             }

//             // If j reached needle length,
//             // entire needle matched.
//             if (j == needle.length()) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }

// Line-by-Line Explanation
// Method Declaration
// public int strStr(String haystack, String needle)
// haystack = main string in which we search.
// needle = substring to find.
// Returns the index of the first occurrence.
// Outer Loop
// for (int i = 0; i <= haystack.length() - needle.length(); i++)
// i = possible starting position of needle.
// We only go until
// haystack.length() - needle.length()

// because after that there isn't enough space left for a complete match.

// Reset Matching Pointer
// int j = 0;
// j is used to compare characters of needle.
// Starts from the first character every time.
// Character Comparison
// while (j < needle.length() &&
//        haystack.charAt(i + j) == needle.charAt(j))

// Checks:

// j < needle.length()
// Have we compared all characters?
// haystack.charAt(i+j) == needle.charAt(j)
// Are current characters equal?

// If both are true:

// j++;

// Move to the next character.

// Match Found?
// if (j == needle.length())

// If j reached the length of needle, all characters matched.

// return i;

// Return the starting index.

// No Match Anywhere
// return -1;

// Executed when the loop finishes and no occurrence is found.

// Dry Run
// Input
// haystack = "sadbutsad"
// needle = "sad"
// Lengths
// haystack.length() = 9
// needle.length() = 3

// Loop:

// i = 0 to 6
// Iteration 1
// i = 0
// j = 0

// Compare:

// haystack[0] = 's'
// needle[0] = 's'

// Match

// j = 1

// Compare:

// haystack[1] = 'a'
// needle[1] = 'a'

// Match

// j = 2

// Compare:

// haystack[2] = 'd'
// needle[2] = 'd'

// Match

// j = 3

// Now

// j == needle.length()
// 3 == 3

// True

// return 0

// Output:

// 0





class Solution {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;

        int[] lps = buildLPS(needle);

        int i = 0; // haystack pointer
        int j = 0; // needle pointer

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            // Complete match found
            if (j == needle.length()) {
                return i - j;
            }

            // Mismatch after some matches
            else if (i < haystack.length() &&
                     haystack.charAt(i) != needle.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String pattern) {

        int[] lps = new int[pattern.length()];

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {

                len++;
                lps[i] = len;
                i++;

            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}


// Algorithm (Interview Version)
// Build the LPS array for needle.
// Use two pointers:
// i for haystack
// j for needle
// If characters match, increment both pointers.
// If j reaches needle.length(), return i - j.
// On mismatch:
// If j > 0, set j = lps[j - 1].
// Otherwise increment i.
// If no match is found, return -1.
// Why KMP is Optimal?

// Instead of restarting from the beginning of needle after a mismatch, KMP uses the LPS array to jump directly to the next possible matching position.

// Complexity
// Time  : O(n + m)
// Space : O(m)

// where:

// n = haystack.length()
// m = needle.length()

// This is the standard optimal solution expected in interviews for "Find the Index of the First Occurrence in a String".










// Let's forget the code for a moment and understand why KMP was invented.

// Problem with Brute Force

// Suppose:

// haystack = "abababc"
// needle   = "ababc"

// Brute force starts:

// abababc
// ababc

// Matches:

// a=a ✓
// b=b ✓
// a=a ✓
// b=b ✓

// Now:

// a != c ✗

// Brute force says:

// "Okay, start again from the next position."

// So it rechecks many characters that we already know.

// KMP's Thinking

// After matching:

// abab

// and failing at:

// a != c

// KMP asks:

// "Do I really need to start from zero?"

// Notice:

// abab

// Inside this matched part:

// Prefix = "ab"
// Suffix = "ab"

// Since the suffix is already "ab", we know the next comparison can continue from there.

// That's exactly what the LPS array stores.

// What does LPS store?

// Take:

// Pattern = "ababd"
// Index 0
// "a"

// No common prefix-suffix.

// LPS[0] = 0
// Index 1
// "ab"

// Prefixes:

// a

// Suffixes:

// b

// No match.

// LPS[1] = 0
// Index 2
// "aba"

// Prefixes:

// a
// ab

// Suffixes:

// a
// ba

// Longest common:

// a

// Length:

// 1
// LPS[2] = 1
// Index 3
// "abab"

// Prefixes:

// a
// ab
// aba

// Suffixes:

// b
// ab
// bab

// Longest common:

// ab

// Length:

// 2
// LPS[3] = 2

// Final:

// Pattern : a b a b d
// Index   : 0 1 2 3 4
// LPS     : 0 0 1 2 0
// Why do we need LPS?

// Suppose we matched:

// abab

// and then mismatch occurs.

// Current:

// j = 4

// KMP looks at:

// lps[j-1]
// =
// lps[3]
// =
// 2

// Meaning:

// "Among the 4 matched characters (abab), the largest prefix that is also a suffix has length 2."

// That prefix-suffix is:

// ab

// So instead of restarting from:

// j = 0

// KMP jumps to:

// j = 2

// and continues.

// Visual Example

// Pattern:

// ababd

// Matched so far:

// abab

// Mismatch occurs.

// Since:

// lps[3] = 2

// We know:

// ab(ab)
//    ↑
// suffix

// (ab)ab
//  ↑
// prefix

// The last "ab" already matches the first "ab".

// So why compare them again?

// KMP skips them.

// The Magic Line

// Whenever mismatch occurs:

// j = lps[j - 1];

// This means:

// "Move pattern pointer to the next best matching prefix."

// Not:

// j = 0;
// Real-Life Analogy

// Imagine you're typing:

// ababd

// and you've already confirmed:

// abab

// Then the next character fails.

// Instead of forgetting everything and starting again:

// a b a b

// you notice:

// ab

// appears at both the beginning and the end.

// So you keep that knowledge and continue from there.

// That's exactly what KMP does.

// The One Thing to Remember

// LPS tells KMP how many characters are already guaranteed to match after a mismatch, so KMP doesn't compare those characters again.

// Once this idea is clear, the code becomes much easier to understand.

// Would you like me to do a 
// full dry run of KMP on a small example (haystack = "abababc" and needle = "ababc") showing every movement of i, j, and LPS? That is usually the point where KMP finally clicks.

// Do a full dry run of KMP on a small example showing every movement of i, j, and LPS

// Perfect. Let's do a complete KMP dry run.

// Example
// haystack = "abababc"
// needle   = "ababc"
// Step 1: Build LPS Array

// Pattern:

// a b a b c
// 0 1 2 3 4
// i = 1
// compare pattern[1] and pattern[0]

// b != a
// lps[1] = 0

// LPS:

// [0,0,_,_,_]
// i = 2
// compare pattern[2] and pattern[0]

// a == a
// len = 1
// lps[2] = 1

// LPS:

// [0,0,1,_,_]
// i = 3
// compare pattern[3] and pattern[1]

// b == b
// len = 2
// lps[3] = 2

// LPS:

// [0,0,1,2,_]
// i = 4
// compare pattern[4] and pattern[2]

// c != a

// Current:

// len = 2

// Jump:

// len = lps[1]
//     = 0

// Again:

// c != a

// So:

// lps[4] = 0

// Final LPS:

// Pattern : a b a b c
// Index   : 0 1 2 3 4
// LPS     : 0 0 1 2 0
// Step 2: Search

// Initial:

// i = 0
// j = 0

// where

// i -> haystack pointer
// j -> needle pointer
// Iteration 1
// haystack[i] = a
// needle[j]   = a

// Match

// i=1
// j=1
// Iteration 2
// haystack[1] = b
// needle[1]   = b

// Match

// i=2
// j=2
// Iteration 3
// haystack[2] = a
// needle[2]   = a

// Match

// i=3
// j=3
// Iteration 4
// haystack[3] = b
// needle[3]   = b

// Match

// i=4
// j=4
// Iteration 5
// haystack[4] = a
// needle[4]   = c

// Mismatch ❌

// Current:

// j = 4

// KMP uses:

// j = lps[j-1]
// j = lps[3]
// j = 2

// Notice:

// i stays 4

// This is the key point.

// Current State
// i = 4
// j = 2

// Compare again:

// haystack[4] = a
// needle[2]   = a

// Match

// i=5
// j=3
// Next
// haystack[5] = b
// needle[3]   = b

// Match

// i=6
// j=4
// Next
// haystack[6] = c
// needle[4]   = c

// Match

// i=7
// j=5

// Now:

// j == needle.length()
// 5 == 5

// Pattern found.

// Return:

// i - j
// 7 - 5
// 2

// Answer:

// 2
// Why KMP Saved Work

// At mismatch:

// Matched = abab

// Brute Force would restart:

// j = 0

// and compare all characters again.

// KMP noticed:

// abab

// has:

// Prefix = ab
// Suffix = ab

// Length:

// 2

// from:

// lps[3] = 2

// So it directly jumped:

// j = 2

// and skipped unnecessary comparisons.

// Most Important Moment

// Before mismatch:

// haystack : a b a b a b c
//                 ↑

// needle   : a b a b c
//                 ↑

// Mismatch:

// a != c

// Instead of:

// j = 0

// KMP does:

// j = lps[3]
//   = 2

// and continues from:

// needle : a b a b c
//             ↑
//             j=2

// because the first "ab" is already known to match.

// Interview Summary

// When a mismatch occurs after matching j characters, KMP uses lps[j-1] to move j to the longest prefix that is also a suffix, avoiding re-comparison of characters and achieving O(n + m) time complexity.