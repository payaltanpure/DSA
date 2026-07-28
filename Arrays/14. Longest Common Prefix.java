// 14. Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

//1.Brute Force:
// Algorithm: Longest Common Prefix
// If the array is empty or null, return empty string "".
// Take an empty string ans to store the common prefix.
// Use the first string as the reference string.
// Traverse each character of the first string using index j.
// Store current character of first string in variable ch.
// Compare this character with the character at same index j in all remaining strings.

// If any string:

// has length less than or equal to j, or
// character at index j is different from ch

// then return ans.

// If all strings have same character at index j, append ch to ans.
// After completing the loop, return ans.

//code:
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        String ans = "";

        for (int j = 0; j < strs[0].length(); j++) {

            char ch = strs[0].charAt(j);

            for (int i = 1; i < strs.length; i++) {

                if (j >= strs[i].length() || strs[i].charAt(j) != ch) {
                    return ans;
                }
            }

            ans += ch;
        }

        return ans;
    }
}

// 2. Best Optimal Solution

// Optimal Algorithm: Longest Common Prefix
// If strs is null or empty, return "".
// Take the first string as prefix.
// Traverse remaining strings one by one.
// For each string, check whether it starts with current prefix.
// If not, remove the last character from prefix.
// Repeat until current string starts with prefix.
// If prefix becomes empty, return "".
// After checking all strings, return prefix.

// code:
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }
}

// Visual Summary
// Initial prefix

// flower│▼

// flow startsWith(flower)? ❌

// flower
// flowe
// flow ✅

// Current prefix = flow

// Then

// flight startsWith(flow)? ❌

// flow
// flo
// fl ✅

// Current prefix = fl

// Return

// fl

// How startsWith() Works

// Suppose

// String s = "flower";
// Expression Result
// s.startsWith("f") true
// s.startsWith("fl") true
// s.startsWith("flo") true
// s.startsWith("flower") true
// s.startsWith("flowe") true
// s.startsWith("flowering") false
// s.startsWith("low") false
// s.startsWith("ower") false

// Internally, startsWith() compares the prefix characters one by one from the
// beginning of the string.

// For example:

// "flight".startsWith("fl")

// Comparison:

// flight
// ||
// fl
// f == f ✅
// l == l ✅

// All characters in "fl" matched the start of "flight", so it returns true.

// Another example:

// "flight".startsWith("flo")

// Comparison:

// flight
// flo
// f == f ✅
// l == l ✅
// i != o ❌

// A mismatch occurs, so it returns false.

// Time Complexity
// In the worst case, the prefix may be shortened character by character.
// Overall time complexity

// is O(N × M), where:
// N = number of strings
// M = length of the longest

// string (or initial prefix)

// This solution is efficient and is the standard approach used for this
// problem.