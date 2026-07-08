13. Roman to Integer
Solved
Easy
Topics
premium lock icon
Companies
Hint
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 


class Solution {
    public int romanToInt(String s) {
        // int sum = 0;
        // int len = s.length();

        // for (int i = 0; i < len; i++) {
        //     if (s.charAt(i) == 'I') {
        //         sum += 1;
        //     } else if (s.charAt(i) == 'V') {
        //         sum += 5;
        //     } else if (s.charAt(i) == 'X') {
        //         sum += 10;
        //     } else if (s.charAt(i) == 'L') {
        //         sum += 50;
        //     } else if (s.charAt(i) == 'C') {
        //         sum += 100;
        //     } else if (s.charAt(i) == 'D') {
        //         sum += 500;
        //     } else {
        //         sum += 1000;
        //     }
        // }
        // return sum;




            // Your code simply adds all Roman numeral values, so:

            // For "MCMXCIV"

            // Symbol	Value
            // M	1000
            // C	100
            // M	1000
            // X	10
            // C	100
            // I	1
            // V	5

            // Total = 1000 + 100 + 1000 + 10 + 100 + 1 + 5 = 2216 ❌

            // Why the expected answer is 1994?

            // Roman numerals use the subtraction rule:

            // CM = 900 (1000 - 100)
            // XC = 90 (100 - 10)
            // IV = 4 (5 - 1)

            // So:

            // MCMXCIV

            // M  = 1000
            // CM = 900
            // XC = 90
            // IV = 4

            // Total = 1000 + 900 + 90 + 4 = 1994
            // Logic to handle subtraction

            // If the current symbol's value is less than the next symbol's value, subtract it; otherwise add it.

            // Example:

            // M C M X C I V
            // ↑   ↑   ↑

            // C < M → subtract 100
            // X < C → subtract 10
            // I < V → subtract 1

            // ry Run for "MCMXCIV"
            // M = 1000      add      sum = 1000
            // C < M         subtract sum = 900
            // M = 1000      add      sum = 1900
            // X < C         subtract sum = 1890
            // C = 100       add      sum = 1990
            // I < V         subtract sum = 1989
            // V = 5         add      sum = 1994



        // simply when the current letters value is less than next letter substract current letters value from sum or else add as we do it in normal case - this is one of the rule of converting roman into digits
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = value(s.charAt(i));

            if (i < s.length() - 1 &&
                curr < value(s.charAt(i + 1))) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        return sum;
    }

    public int value(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}

// This solution is optimal, not brute force.

// Time Complexity
// You traverse the string only once.
// Each character is processed in O(1) time.
// Time Complexity = O(n)

// where n is the length of the Roman numeral string.

// Space Complexity
// Space Complexity = O(1)

// because only a few variables (sum, curr) are used.