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
// Create empty list result

// For each query word in queries:

//     For each dictionary word in dictionary:

//         mismatch = 0

//         For each index from 0 to word length - 1: from any array weather queries or dictionary as they have words of same length

//             If query[index] != dictionary[index]:
//                 mismatch = mismatch + 1

//             If mismatch > 2:
//                 Stop checking this dictionary word start comparing with next dictionary word goes to j's loop

//         If mismatch <= 2:
//             Add query word to result
//             Stop checking more dictionary words for this query  ,start comparing with next dictionary word goes to j's loop

// Return result




class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
       List<String> words = new ArrayList<>();
        for(int i=0; i<queries.length; i++)
        {
            for(int j=0; j<dictionary.length;j++)
            {
                int count=0;
                for (int k=0;k<queries[i].length();k++)
                //here we can use dictionary[j]also as all the words in both arrays are of same length
                {
                    if(queries[i].charAt(k)!=dictionary[j].charAt(k))
                    {
                       count++;
                       if (count>2)
                       {
                         break;
                       }
                    }
                }
                if(count<=2)
                {
                    words.add(queries[i]);
                    break;
                }
            }
        }
        return words;
    }
}