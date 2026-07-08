// 290. Word Pattern
// Easy
// Topics
// premium lock icon
// Companies
// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

// Each letter in pattern maps to exactly one unique word in s.
// Each unique word in s maps to exactly one letter in pattern.
// No two letters map to the same word, and no two words map to the same letter.

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"

// Output: true

// Explanation:

// The bijection can be established as:

// 'a' maps to "dog".
// 'b' maps to "cat".
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"

// Output: false

// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"

// Output: false

// A simple way to remember the two maps

// Think of two dictionaries:

// Character → Word: "If I see this character again, it must always have the same word."
// Word → Character: "If I see this word again, it must always have the same character."

// Both conditions must hold for a one-to-one (bijection) mapping.

// Result: chartoword
// a    b 
// dog cat
// wordtochar
// dog      cat
// a         b

// a      b         b     a
// dog    cat       cat   fish 
// at last a = fish here condition fails so return false
class Solution {

    public boolean wordPattern(String pattern, String s) {

        // Split the string into individual words.
        // Example:
        // s = "dog cat cat dog"
        // words = ["dog", "cat", "cat", "dog"]
        String[] words = s.split(" ");

        // If the number of characters in pattern and
        // the number of words are different,
        // then one-to-one mapping is impossible.
        if (pattern.length() != words.length) {
            return false;
        }

        // Map to store:
        // Character -> Word
        HashMap<Character, String> charToWord = new HashMap<>();

        // Map to store:
        // Word -> Character
        HashMap<String, Character> wordToChar = new HashMap<>();

        // Traverse both pattern and words together
        for (int i = 0; i < pattern.length(); i++) {

            // Current character from pattern
            char ch = pattern.charAt(i);

            // Current word from words array
            String word = words[i];

            // -----------------------------
            // Check Character -> Word mapping
            // -----------------------------
            if (charToWord.containsKey(ch)) {

                // Character already has a mapped word.
                // If it is different from the current word,
                // pattern is violated.
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }

            } else {

                // Character is seen for the first time.
                // Store its mapping.
                charToWord.put(ch, word);
            }

            // -----------------------------
            // Check Word -> Character mapping
            // -----------------------------
            if (wordToChar.containsKey(word)) {

                // Word already has a mapped character.
                // If it is different from the current character,
                // two characters are mapping to the same word.
                if (wordToChar.get(word) != ch) {
                    return false;
                }

            } else {

                // Word is seen for the first time.
                // Store its mapping.
                wordToChar.put(word, ch);
            }
        }

        // All mappings are consistent.
        return true;
    }
}

// Example
// pattern = "abba"

// s = "dog cat cat dog"

// After splitting,

// words = ["dog", "cat", "cat", "dog"];

// Initially

// charToWord = {}

// wordToChar = {}
// Iteration 1 (i = 0)
// ch = 'a'
// word = "dog"

// Current Maps

// charToWord = {}

// wordToChar = {}
// First if
// if(charToWord.containsKey(ch))

// becomes

// if(charToWord.containsKey('a'))

// Question:

// Does the map contain 'a'?

// Current map

// {}

// No.

// So

// containsKey('a')

// returns

// false

// Hence Java goes to

// else

// and executes

// charToWord.put(ch, word);

// which becomes

// charToWord.put('a', "dog");

// Now map becomes

// charToWord

// a → dog
// Second if
// if(wordToChar.containsKey(word))

// becomes

// if(wordToChar.containsKey("dog"))

// Current map

// {}

// Contains dog?

// No.

// Go to else.

// Execute

// wordToChar.put("dog",'a');

// Now

// wordToChar

// dog → a

// Maps after first iteration

// charToWord

// a → dog

// wordToChar

// dog → a
// Iteration 2
// ch='b'

// word="cat"

// Current maps

// charToWord

// a → dog

// wordToChar

// dog → a

// First if

// containsKey('b')

// No.

// Store

// charToWord.put('b',"cat");

// Now

// charToWord

// a → dog
// b → cat

// Second map

// containsKey("cat")

// No.

// Store

// wordToChar.put("cat",'b');

// Now

// wordToChar

// dog → a

// cat → b
// Iteration 3

// Now comes the interesting part.

// ch='b'

// word="cat"

// Current maps

// charToWord

// a → dog

// b → cat
// First if
// containsKey('b')

// Question:

// Does map contain b?

// Yes.

// So Java enters

// if

// Now execute

// charToWord.get(ch)

// becomes

// charToWord.get('b')

// HashMap returns

// cat

// Now Java checks

// if(!charToWord.get(ch).equals(word))

// becomes

// if(!"cat".equals("cat"))

// Is

// cat equals cat ?

// Yes.

// .equals()

// returns

// true

// Now

// !

// makes it

// false

// So

// if(false)

// Nothing happens.

// Everything is correct.

// Now second map.

// containsKey("cat")

// Yes.

// Execute

// wordToChar.get("cat")

// returns

// 'b'

// Now compare

// if(wordToChar.get(word)!=ch)

// becomes

// if('b'!='b')

// False.

// Continue.

// Iteration 4
// ch='a'

// word="dog"

// Current maps

// charToWord

// a → dog

// b → cat

// First if

// containsKey('a')

// Yes.

// Retrieve

// charToWord.get('a')

// returns

// dog

// Compare

// if(!"dog".equals("dog"))

// False.

// Good.

// Second map

// wordToChar.get("dog")

// returns

// a

// Compare

// if('a'!='a')

// False.

// Loop finishes.

// Return

// true
// Now let's see why the if is needed.

// Example

// pattern = "abba"

// dog cat fish dog

// Iteration 1

// a → dog

// Iteration 2

// b → cat

// Iteration 3

// Current

// ch='b'

// word="fish"

// Map already has

// b → cat

// So

// charToWord.get('b')

// returns

// cat

// Now compare

// if(!"cat".equals("fish"))

// Are they equal?

// No.

// .equals() returns

// false

// !false

// becomes

// true

// So Java executes

// return false;

// because

// Earlier

// b → cat

// Now

// b → fish

// One character is trying to map to two different words.

// Not allowed.

// Why do we need the second HashMap?

// Consider

// pattern = "ab"

// dog dog

// After first iteration

// charToWord

// a → dog

// wordToChar

// dog → a

// Second iteration

// ch='b'

// word="dog"

// First map says

// containsKey('b')

// No.

// So it happily stores

// b → dog

// Now

// charToWord

// a → dog

// b → dog

// Looks okay to the first map!

// But it's actually wrong, because the same word "dog" is being assigned to two
// different characters.

// That's why we check the second map.

// wordToChar.containsKey("dog")

// Yes.

// Retrieve

// wordToChar.get("dog")

// returns

// 'a'

// Current character is

// 'b'

// Now compare

// if('a'!='b')

// This is true, so we return false.

// A simple way to remember the two maps

// Think of two dictionaries:

// Character → Word: "If I see this character again, it must always have the
// same word."
// Word → Character: "If I see this word again, it must always have the same
// character."

// Both conditions must hold for a one-to-one (bijection) mapping.

// I have one small question for you.

// Suppose the input is:

// pattern = "abc"

// s = "dog dog dog"

// After the first iteration, the maps are:

// charToWord:
// a → dog

// wordToChar:
// dog → a

// Now at the second iteration:

// ch = 'b'
// word = "dog"

// Which line will return false?

// if (!charToWord.get(ch).equals(word))
// if (wordToChar.get(word) != ch)

// Try answering this. If you get it right, you've understood exactly why we
// need two HashMaps.