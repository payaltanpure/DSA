// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:

// Input: s = "egg", t = "add"

// Output: true

// Explanation:

// The strings s and t can be made identical by:

// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.
// Example 2:

// Input: s = "f11", t = "b23"

// Output: false

// Explanation:

// The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

// Example 3:

// Input: s = "paper", t = "title"

// Output: true

// all is about checking positions, map1 and map2 stores position of before seen that charcter not the charcter
class Solution {
    public boolean isIsomorphic(String s, String t) {

        // If lengths are different, strings cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Array to store the last seen position of characters in string s
        int[] map1 = new int[256];

        // Array to store the last seen position of characters in string t
        int[] map2 = new int[256];

        // Traverse both strings together
        for (int i = 0; i < s.length(); i++) {

            // Current character from string s
            char c1 = s.charAt(i);

            // Current character from string t
            char c2 = t.charAt(i);

            /*
             * Check whether both characters were last seen
             * at the same position.
             *
             * If not, mapping is inconsistent.
             */
            if (map1[c1] != map2[c2]) {
                return false;
            }

            /*
             * Store the current position of both characters.
             *
             * We store i + 1 instead of i because arrays
             * are initially filled with 0.
             *
             * 0 -> character has never appeared
             * 1 -> appeared at index 0
             * 2 -> appeared at index 1
             * 3 -> appeared at index 2
             */
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }

        // No conflicts found
        return true;
    }
}

// That's completely normal. The array solution is clever, so it's hard to
// understand the first time. Let's first understand the idea without looking at
// the code.

// What does the problem actually ask?

// Suppose

// s = egg
// t = add

// Can we replace every character in s to make it equal to t?

// e → a
// g → d

// Now replace:

// egg
// ↓↓↓
// add

// Yes.

// So the answer is true.

// What is NOT allowed?

// Example:

// s = foo
// t = bar

// Let's try mapping.

// f → b
// o → a

// Now the second o should also become a.

// But in t, the third character is r.

// So we'd need

// o → r

// Now the same character (o) is mapping to both a and r.

// ❌ Not allowed.

// Another example
// s = ab
// t = aa

// Can we map?

// a → a
// b → a

// Now two different characters (a and b) map to the same character (a).

// ❌ Not allowed.

// The real question

// Whenever we see two characters,

// s[i]
// t[i]

// we want to know:

// Have I seen these characters before?

// If yes,

// they must have appeared together before.

// Let's take an example
// s = paper
// t = title

// Look at the characters one by one.

// Index s t
// 0 p t
// 1 a i
// 2 p t
// 3 e l
// 4 r e

// Notice

// At index 2

// p
// t

// We already saw

// p
// t

// at index 0.

// So everything is consistent.

// Now look at

// s = badc
// t = baba
// Index s t
// 0 b b
// 1 a a
// 2 d b

// At index 2,

// d
// b

// But

// b

// already appeared with

// b

// at index 0.

// Now suddenly

// b

// is paired with

// d

// Impossible.

// Answer = false.

// Now comes the trick

// Instead of storing

// e → a
// g → d

// we store

// Where did I last see this character?

// For

// egg

// we keep

// Character Last Seen
// e 0
// g 2

// Similarly for

// add
// Character Last Seen
// a 0
// d 2

// Notice something?

// Whenever characters match,

// their last occurrence positions are always the same.

// Let's see visually
// s = egg
// t = add

// Initially

// e -> never seen

// g -> never seen

// a -> never seen

// d -> never seen
// Index 0
// e
// a

// Both are new.

// Perfect.

// Now remember

// e was seen at 0

// a was seen at 0
// Index 1
// g
// d

// Both are new.

// Remember

// g at 1

// d at 1
// Index 2

// Again

// g
// d

// Question:

// "When did I last see g?"

// Answer

// 1

// "When did I last see d?"

// Answer

// 1

// Same answer.

// Everything is fine.

// Now look at a wrong example
// foo
// bar

// Index 0

// f
// b

// Remember

// f ->0

// b ->0

// Index 1

// o
// a

// Remember

// o ->1

// a ->1

// Index 2

// o
// r

// Question

// "When did I last see o?"

// 1

// "When did I last see r?"

// Never

// These answers are different.

// That means

// o

// was previously paired with

// a

// but now it's paired with

// r

// Impossible.

// Return false.

// Why two arrays?

// One array remembers

// Characters of s

// Example

// map1

// e -> last seen
// g -> last seen

// Second array remembers

// Characters of t

// Example

// map2

// a -> last seen
// d -> last seen

// Then every time we simply compare

// Was s[i] last seen at the same position as t[i]?

// If yes

// ✔ Continue.

// If no

// ❌ Return false.

// The one-line idea

// The key line is:

// if (map1[c1] != map2[c2])
// return false;

// This means:

// If the last occurrence of c1 is different from the last occurrence of c2,
// then these characters are not following a consistent mapping, so the strings
// cannot be isomorphic.

// I recommend learning the HashMap solution first because its logic ("e maps to
// a") is more intuitive. Once that clicks, the array solution feels like a
// compact optimization of the same idea.

// give me code with comments

// Here is the same optimized array solution with easy comments explaining every
// line.

// class Solution {
// public boolean isIsomorphic(String s, String t) {

// // If lengths are different, strings cannot be isomorphic
// if (s.length() != t.length()) {
// return false;
// }

// // Array to store the last seen position of characters in string s
// int[] map1 = new int[256];

// // Array to store the last seen position of characters in string t
// int[] map2 = new int[256];

// // Traverse both strings together
// for (int i = 0; i < s.length(); i++) {

// // Current character from string s
// char c1 = s.charAt(i);

// // Current character from string t
// char c2 = t.charAt(i);

// /*
// * Check whether both characters were last seen
// * at the same position.
// *
// * If not, mapping is inconsistent.
// */
// if (map1[c1] != map2[c2]) {
// return false;
// }

// /*
// * Store the current position of both characters.
// *
// * We store i + 1 instead of i because arrays
// * are initially filled with 0.
// *
// * 0 -> character has never appeared
// * 1 -> appeared at index 0
// * 2 -> appeared at index 1
// * 3 -> appeared at index 2
// */
// map1[c1] = i + 1;
// map2[c2] = i + 1;
// }

// // No conflicts found
// return true;
// }
// }
// Dry Run
// Input
// s = "egg"
// t = "add"

// Initially

// map1 = all 0
// map2 = all 0
// Iteration 1 (i = 0)
// c1 = 'e'
// c2 = 'a'

// Check

// map1['e'] = 0
// map2['a'] = 0

// Equal ✅

// Store

// map1['e'] = 1
// map2['a'] = 1
// Iteration 2 (i = 1)
// c1 = 'g'
// c2 = 'd'

// Check

// map1['g'] = 0
// map2['d'] = 0

// Equal ✅

// Store

// map1['g'] = 2
// map2['d'] = 2
// Iteration 3 (i = 2)
// c1 = 'g'
// c2 = 'd'

// Check

// map1['g'] = 2
// map2['d'] = 2

// Equal ✅

// Store

// map1['g'] = 3
// map2['d'] = 3

// Loop ends.

// return true
// Why does map1[c1] != map2[c2] work?

// Suppose:

// s = "foo"
// t = "bar"

// At i = 2

// c1 = 'o'
// c2 = 'r'

// Now,

// map1['o'] = 2 // 'o' was seen before
// map2['r'] = 0 // 'r' has never been seen

// Since

// 2 != 0

// the algorithm knows that 'o' was previously paired with a different character
// ('a'), but now it is being paired with 'r'.

// So it returns false.

// Time Complexity
// O(n) — one traversal of the strings.
// Space Complexity
// O(1) — two fixed-size arrays of length 256.

// This solution is popular in coding interviews because it avoids HashMap
// lookups while still checking the character mapping correctly.

// when the char in strings are stored in m1 and m2

// Excellent question. This is exactly where most people get confused.

// The answer is:

// The characters are never stored in map1 and map2.

// Only their last seen position is stored.

// Let's understand this carefully.

// Suppose
// s = "egg"
// t = "add"

// Initially

// int[] map1 = new int[256];
// int[] map2 = new int[256];

// Both arrays contain only zeros.

// map1

// Index(ASCII) Value
// ----------------------
// 97 ('a') 0
// 98 ('b') 0
// ...
// 100 ('d') 0
// 101 ('e') 0
// 103 ('g') 0
// ...

// map2 is the same.

// Notice:

// There is no character stored.

// Only numbers.

// Iteration 1
// char c1 = 'e';
// char c2 = 'a';

// Now look at

// map1[c1]

// Java automatically converts

// 'e'

// to its ASCII value

// 101

// So this actually becomes

// map1[101]

// Similarly,

// map2['a']

// becomes

// map2[97]

// Initially,

// map1[101] = 0
// map2[97] = 0

// Then we execute

// map1[c1] = i + 1;
// map2[c2] = i + 1;

// Since

// i = 0

// we store

// map1[101] = 1;
// map2[97] = 1;

// Now the arrays look like

// map1

// ASCII Character Value
// 101 e 1

// map2

// ASCII Character Value
// 97 a 1

// Notice again:

// We did not store 'e'.

// We stored 1 at the position corresponding to 'e'.

// Iteration 2
// c1 = 'g'
// c2 = 'd'

// ASCII values

// g = 103

// d = 100

// Check

// map1[103]

// It is

// 0

// because 'g' has never appeared.

// Then

// map1[103] = 2;
// map2[100] = 2;

// Arrays become

// map1

// e -> 1
// g -> 2

// map2

// a -> 1
// d -> 2
// Iteration 3

// Again

// c1 = 'g'
// c2 = 'd'

// Now

// map1['g']

// means

// map1[103]

// which is already

// 2

// Similarly

// map2['d']

// is

// 2

// They are equal.

// Everything is consistent.

// Think of it like a cupboard

// Imagine an array as a cupboard with 256 drawers.

// Drawer numbers are ASCII values.

// Drawer 97 -> a

// Drawer 98 -> b

// Drawer 99 -> c

// Drawer 100 -> d

// Drawer 101 -> e

// Drawer 102 -> f

// Drawer 103 -> g

// When you see 'e', you don't put 'e' into the drawer.

// You open drawer 101 and write the last position where 'e' was seen.

// For example,

// Drawer 101 (e)

// Last seen = 1

// Later,

// Drawer 103 (g)

// Last seen = 2

// The character itself is identified by which drawer you're using. The drawer's
// contents are just the last-seen position.

// In one sentence
// map1[c1] = i + 1;

// does not mean

// "Store the character c1."

// It means

// "Use the character c1 as an array index, and store its last-seen position (i
// + 1) at that index."

// For example:

// map1['e'] = 1;

// is actually equivalent to:

// map1[101] = 1; // 101 is the ASCII value of 'e'

// So map1 is a lookup table: character → last seen position.

// This distinction is the key to understanding the algorithm.