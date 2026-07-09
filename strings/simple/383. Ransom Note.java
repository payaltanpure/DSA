// 383. Ransom Note
// Easy
// Topics
// premium lock icon
// Companies
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

 

// Example 1:

// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:

// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:

// Input: ransomNote = "aa", magazine = "aab"
// Output: true





// class Solution {

//     public boolean canConstruct(String ransomNote, String magazine) {

//         // Convert the magazine string into a character array.
//         // Why?
//         // Strings in Java are immutable (cannot be changed).
//         // We need to mark characters as "used", so we convert it into
//         // a mutable character array.
//         char[] letters = magazine.toCharArray();

//         // Traverse every character of the ransom note.
//         // For each character, we will try to find one matching character
//         // in the magazine.
//         for (int i = 0; i < ransomNote.length(); i++) {

//             // This variable tells whether the current ransomNote character
//             // was found in the magazine.
//             boolean found = false;

//             // Search the current ransomNote character
//             // in the entire magazine.
//             for (int j = 0; j < letters.length; j++) {

//                 // Compare current ransomNote character
//                 // with current magazine character.
//                 if (ransomNote.charAt(i) == letters[j]) {

//                     // Matching character found.
//                     found = true;

//                     // Mark this magazine character as used.
//                     // '#' means this character has already been used
//                     // and cannot be used again.
//                     letters[j] = '#';

//                     // No need to continue searching because
//                     // we already found a matching character.
//                     break;
//                 }
//             }

//             // After checking the whole magazine,
//             // if no matching character was found,
//             // then ransomNote cannot be formed.
//             if (!found) {
//                 return false;
//             }
//         }

//         // Every character of ransomNote was found successfully.
//         return true;
//     }
// }

// Dry Run
// ransomNote = "aa"

// magazine = "aab"

// Initially

// Magazine

// a a b
// First character
// Looking for 'a'

// Found at index 0

// Magazine becomes

// # a b
// Second character
// Looking for 'a'

// Index 0 = #

// Not equal

// Index 1 = a

// Found

// Magazine becomes

// # # b

// Finished

// Return true
// Time Complexity

// Outer loop

// n

// Inner loop

// m

// Overall

// O(n × m)

// Space

// O(m)

// because we created a character array.







// optimal solution 
class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        // Frequency array of size 26.
        //
        // Index 0 -> 'a'
        // Index 1 -> 'b'
        // Index 2 -> 'c'
        // ...
        // Index 25 -> 'z'
        //
        // Each index stores how many times that letter
        // appears in the magazine.
        int[] count = new int[26];



        // ----------------------------------------------------
        // STEP 1
        // Count frequency of every character in magazine.
        // ----------------------------------------------------
        for (int i = 0; i < magazine.length(); i++) {

            // Get current character.
            char ch = magazine.charAt(i);

            // Convert character into array index.
            //
            // Example:
            //
            // 'a' - 'a' = 0
            // 'b' - 'a' = 1
            // 'c' - 'a' = 2
            //
            // ASCII values
            //
            // a = 97
            // b = 98
            // c = 99
            //
            // Example:
            // 'c' - 'a'
            // 99 - 97 = 2
            int index = ch - 'a';

            // Increase frequency of this letter.
            count[index]++;
        }



        // ----------------------------------------------------
        // STEP 2
        // Check whether every character of ransomNote
        // is available in the magazine.
        // ----------------------------------------------------
        for (int i = 0; i < ransomNote.length(); i++) {

            // Current character needed.
            char ch = ransomNote.charAt(i);

            // Convert character into index.
            int index = ch - 'a';

            // If frequency is zero,
            // that means this character is no longer available.
            if (count[index] == 0) {

                // Cannot build ransomNote.
                return false;
            }

            // Use one occurrence of this character.
            //
            // Example:
            //
            // Before using
            //
            // a -> 3
            //
            // After using one 'a'
            //
            // a -> 2
            count[index]--;
        }



        // Every required character was available.
        return true;
    }
}


// Complete Dry Run
// ransomNote = "abc"

// magazine = "aabcc"
// Initial Frequency Array
// Letter

// a b c d e ... z

// Count

// 0 0 0 0 0
// Read first 'a'
// count[0]++

// a=1
// a b c

// 1 0 0
// Read second 'a'
// count[0]++
// a b c

// 2 0 0
// Read 'b'
// count[1]++
// a b c

// 2 1 0
// Read first 'c'
// count[2]++
// a b c

// 2 1 1
// Read second 'c'
// count[2]++
// a b c

// 2 1 2

// Magazine frequencies are now:

// a = 2
// b = 1
// c = 2
// Build the Ransom Note

// Need

// abc
// Need 'a'
// count[a]

// 2

// Available

// Use one

// count[a]--

// Now

// 1

// Remaining

// a=1
// b=1
// c=2
// Need 'b'
// count[b]

// 1

// Available

// Use one

// Remaining

// a=1
// b=0
// c=2
// Need 'c'
// count[c]

// 2

// Available

// Use one

// Remaining

// a=1
// b=0
// c=1

// Finished

// Return true
// Another Dry Run
// ransomNote = "aa"

// magazine = "ab"

// Frequency

// a=1

// b=1

// Need first 'a'

// Available

// Use it

// a=0

// Need second 'a'

// count[a]

// 0

// That means

// No 'a' left in magazine.

// Immediately

// return false;
// Why is the Frequency Array Better?

// Think of the count array as an inventory of available letters.

// Magazine = "aabcc"

// Inventory:

// a → 2
// b → 1
// c → 2

// Every time you use a letter for the ransom note, you remove one from the inventory.

// Need 'a'

// Inventory:

// a → 1
// b → 1
// c → 2

// Need another 'a'

// Inventory:

// a → 0
// b → 1
// c → 2

// Need another 'a' again?

// Inventory says:

// a → 0

// ❌ Not available

// So the answer is false.

// Complexity Comparison
// Approach	Time Complexity	Space Complexity	Reason
// Nested Loops (Brute Force)	O(n × m)	O(m)	For every character in ransomNote, search the entire magazine.
// Frequency Array (Optimal)	O(n + m)	O(1)	Count all letters once, then check each required letter once. The array size is always 26