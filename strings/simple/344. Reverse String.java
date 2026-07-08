
// Code
// Testcase
// Testcase
// Test Result
// Test Result
// 344. Reverse String
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

 

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]





class Solution {
    public void reverseString(char[] s) {
        char temp;
        for(int i=0; i<s.length/2; i++)
        {
            temp= s[i];
            s[i]= s[s.length-1-i];
            s[s.length-1-i]= temp;
        }
    }
}

// s[s.length-1-i]; here we used -i becoz we want to change last position as i changes so -i 
// in first iteration i=0 so minus 0 so it remains at last position
// in sec iteration i=1 so minus 1 so it goes at second last position