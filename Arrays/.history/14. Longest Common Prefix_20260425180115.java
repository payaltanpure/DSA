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
        
        if (strs == null || strs.length == 0) return "";
        
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


