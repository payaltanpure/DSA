// 242. Valid Anagram
// Easy
// Topics
// premium lock icon
// Companies
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true

// Example 2:

// Input: s = "rat", t = "car"

// Output: false

// Approach	Idea	Time	Space	Interview Rating
// Brute Force	Search each character one by one and mark as used	O(n²)	O(n)	⭐⭐
// Sorting	Sort both strings and compare	O(n log n)	O(n)	⭐⭐⭐
// Frequency Count	Count occurrences of each character	O(n)	O(1)	⭐⭐⭐⭐⭐ (Best)

// If both strings contain exactly the same characters with the same frequencies, every increase is canceled by a decrease, so all 26 entries end up as 0. This is why checking that every element is 0 correctly determines whether the strings are anagrams.

class Solution {

    public boolean isAnagram(String s, String t) {

        // Step 1: If both strings have different lengths,
        // they cannot be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create a frequency array of size 26.
        // Each index represents one lowercase English letter.
        // Index 0 -> 'a'
        // Index 1 -> 'b'
        // ...
        // Index 25 -> 'z'
        int[] count = new int[26];

        // Step 3: Traverse both strings simultaneously.
        for (int i = 0; i < s.length(); i++) {

            // Increase the frequency of the current character from string s.
            // Example:
            // 'a' - 'a' = 0
            // 'b' - 'a' = 1
            // 'c' - 'a' = 2
            count[s.charAt(i) - 'a']++;

            // Decrease the frequency of the current character from string t.
            count[t.charAt(i) - 'a']--;
        }

        // Step 4: Check every element of the frequency array.
        // If any value is not 0, the character frequencies are different,
        // so the strings are not anagrams.
        for (int i = 0; i < 26; i++) {

            if (count[i] != 0) {
                return false;
            }
        }

        // Step 5: All frequencies are 0,
        // which means both strings contain the same characters
        // with the same frequency.
        return true;
    }
}

// how this works count[s.charAt(i) - 'a']++;

// // Decrease the frequency of the current character from string t.
// count[t.charAt(i) - 'a']--;

// This is one of the most important concepts in Java and coding interviews.
// Let's understand it step by step.

// The two lines are:

// count[s.charAt(i) - 'a']++;

// count[t.charAt(i) - 'a']--;
// Step 1: The count array
// int[] count = new int[26];

// This creates an array with 26 elements.

// Index : 0 1 2 3 4 5 ... 25
// Value : [0, 0, 0, 0, 0, 0 ... 0]

// Each index represents one alphabet.

// Index Letter
// 0 a
// 1 b
// 2 c
// 3 d
// ... ...
// 25 z
// Step 2: How does 'a' become 0?

// Java stores characters as ASCII/Unicode numbers.

// Character ASCII
// 'a' 97
// 'b' 98
// 'c' 99
// 'd' 100

// Now suppose

// char ch = 'c';

// Then

// ch - 'a'

// actually means

// 99 - 97

// which equals

// 2

// So

// count[ch - 'a']

// becomes

// count[2]

// which is the position for 'c'.

// Example 1

// Suppose

// char ch = 'a';

// Then

// 'a' - 'a'

// 97 - 97

// = 0

// So

// count['a' - 'a']

// becomes

// count[0]
// Example 2

// Suppose

// char ch = 'f';

// ASCII values

// 'f' = 102
// 'a' = 97

// Subtract

// 102 - 97 = 5

// So

// count['f' - 'a']

// means

// count[5]
// Step 3: What does ++ do?

// Suppose the array is

// Index : 0 1 2 3 4 5
// Value : 0 0 0 0 0 0

// Character is

// 'a'

// Then

// count['a' - 'a']++;

// becomes

// count[0]++;

// Now

// Index : 0 1 2 3 4 5
// Value : 1 0 0 0 0 0

// It means

// We found one 'a'.

// Suppose another 'a' comes.

// Again

// count[0]++;

// Now

// Index : 0 1 2 3 4 5
// Value : 2 0 0 0 0 0

// Now there are 2 a's.

// Step 4: What does -- do?

// Now look at

// count[t.charAt(i)-'a']--;

// Suppose

// t = "a"

// Then

// count[0]--;

// Array becomes

// Before

// [2,0,0,0...]

// ↓

// After

// [1,0,0,0...]

// It means

// One 'a' from t canceled one 'a' from s.

// Complete Example

// Suppose

// s = "abc"

// t = "cab"

// Initially

// [a,b,c]

// [0,0,0]
// Iteration 1
// s[0] = a
// count[0]++;

// Array

// a b c

// 1 0 0

// Now

// t[0]=c
// count[2]--;

// Array

// a b c

// 1 0 -1
// Iteration 2
// s[1]=b
// count[1]++;

// Array

// 1 1 -1

// Now

// t[1]=a
// count[0]--;

// Array

// 0 1 -1
// Iteration 3
// s[2]=c
// count[2]++;

// Array

// 0 1 0

// Now

// t[2]=b
// count[1]--;

// Array

// 0 0 0

// Everything becomes 0.

// That means every character that appeared in s also appeared the same number
// of times in t.

// What if they are not anagrams?

// Suppose

// s = "abc"

// t = "aac"

// Process:

// After s

// a = 1
// b = 1
// c = 1

// After subtracting t

// a = -1
// b = 1
// c = 0

// Final array

// a = -1
// b = 1
// c = 0

// Since some values are not 0, the strings are not anagrams.

// The key idea to remember
// count[s.charAt(i) - 'a']++;

// means:

// "Take the current letter from s, convert it into an array index (a→0, b→1,
// ..., z→25), and increase its frequency."

// count[t.charAt(i) - 'a']--;

// means:

// "Take the current letter from t, convert it into the same array index, and
// decrease its frequency."

// If both strings contain exactly the same characters with the same
// frequencies, every increase is canceled by a decrease, so all 26 entries end
// up as 0. This is why checking that every element is 0 correctly determines
// whether the strings are anagrams.
