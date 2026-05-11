// 2452. Words Within Two Edits of Dictionary

// You are given two string arrays, queries and dictionary. All words in each array comprise of lowercase English letters and have the same length.

// In one edit you can take a word from queries, and change any letter in it to any other letter. Find all words from queries that, after a maximum of two edits, equal some word from dictionary.

// Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits. Return the words in the same order they appear in queries.

// Example 1:

// Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
// Output: ["word","note","wood"]
// Explanation:
// - Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
// - Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
// - It would take more than 2 edits for "ants" to equal a dictionary word.
// - "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
// Thus, we return ["word","note","wood"].

//1.Brute force

// Algorithm: Find Words Within Two Edits
// Input:
// queries[] → list of query words
// dictionary[] → list of dictionary words

// (All words have same length)

// Steps:
// Create an empty result list.

// For each word in queries:

// a. Compare it with every word in dictionary.

// b. For each dictionary word:

// Initialize mismatch count = 0
// Compare both words character by character.
// If characters at same position are different:
// increase mismatch count by 1
// If mismatch count becomes greater than 2:
// stop comparing this pair and move to next dictionary word

// c. After comparing all characters:

// If mismatch count is less than or equal to 2:
// add current query word to result
// stop checking remaining dictionary words for this query
// After processing all query words, return the result list.

//pseudo code
// Create empty list result

// For each query word in queries:

//     For each dictionary word in dictionary:

//         mismatch = 0

//         For each index from 0 to word length - 1: from any array weather queries or dictionary as they have words of same length

//             If query[index] != dictionary[index]:
//                 mismatch = mismatch + 1

//             If mismatch > 2:
//                 Stop checking this dictionary word start comparing with next dictionary  with same queries word  word goes to j's loop

//         If mismatch <= 2:
//             Add query word to result
//             Stop checking more dictionary words for this query  ,start comparing with next dictionary word with same queries word goes to j's loop

// Return result

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {
                int count = 0;
                for (int k = 0; k < queries[i].length(); k++)
                // here we can use dictionary[j]also as all the words in both arrays are of same
                // length
                {
                    if (queries[i].charAt(k) != dictionary[j].charAt(k)) {
                        count++;
                        if (count > 2) {
                            break;
                        }
                    }
                }
                if (count <= 2) {
                    words.add(queries[i]);
                    break;
                }
            }
        }
        return words;
    }
}

// time comp: O(n3)
// space comp: O(1)

// optimal best soltion
// Algorithm in simple language
// Create a HashSet to store patterns made from dictionary words.
// For each word in dictionary:
// store the original word
// make all patterns by replacing one character with *
// make all patterns by replacing two characters with *
// store all of them in the set
// Create an empty answer list.
// For each word in queries:
// first check if the exact word is in the set
// if not, make all one-* patterns and check if any is in the set
// if still not, make all two-* patterns and check if any is in the set
// if any check succeeds, add that query word to the answer list
// Return the answer list.

// pseudo code
// Create empty set called patterns

// For each word in dictionary:
// Add word to patterns

// For each position i in the word:
// Replace character at i with '*'
// Add new pattern to patterns

// For each pair of positions (i, j) in the word:
// Replace character at i with '*'
// Replace character at j with '*'
// Add new pattern to patterns

// Create empty list called result

// For each word in queries:
// found = false

// If word is in patterns:
// found = true

// If not found:
// For each position i in the word:
// Replace character at i with '*'
// If this pattern is in patterns:
// found = true
// Stop this loop

// If not found:
// For each pair of positions (i, j) in the word:
// Replace character at i with '*'
// Replace character at j with '*'
// If this pattern is in patterns:
// found = true
// Stop these loops

// If found is true:
// Add word to result

// Return result


// | Need                  | Best DS    | Why                   |
// | --------------------- | ---------- | --------------------- |
// | Fast existence check  | HashSet    | O(1) contains         |
// | Preserve output order | ArrayList  | Keeps insertion order |
// | Sorted output?        | Not needed | So no TreeSet         |
// | Key-value pairs?      | Not needed | So no HashMap         |



import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Set<String> patterns = new HashSet<>();
        int len = dictionary[0].length();

        for (String word : dictionary) {
            patterns.add(word);

            for (int i = 0; i < len; i++) {
                char[] arr = word.toCharArray();
                arr[i] = '*';
                patterns.add(new String(arr));
            }

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    char[] arr = word.toCharArray();
                    arr[i] = '*';
                    arr[j] = '*';
                    patterns.add(new String(arr));
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : queries) {
            boolean found = false;

            if (patterns.contains(word)) {
                found = true;
            }

            if (!found) {
                for (int i = 0; i < len; i++) {
                    char[] arr = word.toCharArray();
                    arr[i] = '*';
                    if (patterns.contains(new String(arr))) {
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                for (int i = 0; i < len; i++) {
                    for (int j = i + 1; j < len; j++) {
                        char[] arr = word.toCharArray();
                        arr[i] = '*';
                        arr[j] = '*';
                        if (patterns.contains(new String(arr))) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }

            if (found) {
                result.add(word);
            }
        }

        return result;
    }
}


// Time Complexity
// Step 1: Build patterns from dictionary

// For one word of length L:

// 0-star patterns:
// 1
// 1-star patterns:
// L
// 2-star patterns:
// L choose 2 = L(L-1)/2

// Total patterns per word:

// 1 + L + L(L-1)/2

// ≈ O(L²)

// For d dictionary words:

// O(d × L²)
// Step 2: Check queries

// For each query word, generate same patterns:

// O(L²)

// For q query words:

// O(q × L²)
// Total Time
// O((d + q) × L²)
// Space Complexity

// We store all patterns in HashSet.

// Patterns for each dictionary word:

// O(L²)

// For d words:

// O(d × L²)

// So:

// Space = O(d × L²)

// plus result list.

// Why not O(1)?

// Because HashSet stores many strings.

// O(1) means constant extra memory, but here memory grows with input size.

// So definitely not O(1).

// When is O(n²) valid?

// Only if:

// number of words and word length are both represented by same variable n
// and you simplify heavily

// But standard interview analysis should separate variables.

// Correct Final Answer
// Optimized HashSet Pattern Solution
// Time Complexity  = O((queries + dictionary) × L²)
// Space Complexity = O(dictionary × L²)

// Where L = word length.

// Brute Force Comparison
// Brute Force:
// O(q × d × L)
// Optimized:
// O((q + d) × L²)