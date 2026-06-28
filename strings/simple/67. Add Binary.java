
// 67. Add Binary
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given two binary strings a and b, return their sum as a binary string.

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"

// Traverse both strings from right to left, add corresponding bits with carry, store sum%2 as the current bit, update carry as sum/2, and finally reverse the result.
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1; // keep i at last position of a string
        int j = b.length() - 1; // keep i at last position of b string

        int carry = 0;
        // Iteration 1:
        // sum = carry(0) + bitA + bitB
        // carry becomes 1

        // Iteration 2:
        // sum = carry(1) + bitA + bitB
        // carry becomes 0

        // Iteration 3:
        // sum = carry(0) + bitA + bitB
        // ...

        // So:

        // ✓ sum is reset every iteration.
        // ✓ carry stores the carry generated in the previous iteration.
        // ✓ sum starts with that carry and then adds the current bits.

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry; // add carry first into sum, in every iteration sum starts with new carry again

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // add a's char into sum and do i--, here by doing '0' we converted string (as
                                          // a is in string) into no so ascii will be not added digit will be added
                i--;
            }

            if (j >= 0) {

                sum += b.charAt(j) - '0'; // add b's char into sum and do j--
                j--;
            }

            // then find carry and digit to wrte downside in addition

            result.append(sum % 2); // we get first digit from num by doing mod
            carry = sum / 2; // we get second digit from num by doing /
            // eg : 2 (2%2)= 0
            // 2/2= 1
            // so , 1 is carry and 0 is digit
            // 1= 0001
            // 1= 0001
            // = 0002
            // so , carry is 1 and digit is 0
        }

        // again transfer result into string
        return result.reverse().toString();
    }
}

// Algorithm
// Create a StringBuilder result.

// Set:

// i = a.length() - 1;
// j = b.length() - 1;
// carry = 0;
// While i >= 0 or j >= 0 or carry != 0:
// sum = carry
// If i >= 0, add digit from a to sum and decrement i.
// If j >= 0, add digit from b to sum and decrement j.
// Append sum % 2 to result.
// Update carry = sum / 2.
// Reverse result.
// Return result.toString().
// Dry Run
// Input
// a = "1010"
// b = "1011"
// Initial Values
// i = 3
// j = 3
// carry = 0
// result = ""
// Iteration bitA bitB carry(in) sum bit = sum%2 carry(out) result
// 1 0 1 0 1 1 0 "1"
// 2 1 1 0 2 0 1 "10"
// 3 0 0 1 1 1 0 "101"
// 4 1 1 0 2 0 1 "1010"
// 5 - - 1 1 1 0 "10101"
// How sum, %2, and /2 Work
// Iteration 2
// bitA = 1
// bitB = 1
// carry = 0
// sum = 1 + 1 + 0 = 2

// Binary:

// 10

// Current bit:

// sum % 2 = 2 % 2 = 0

// Carry:

// sum / 2 = 2 / 2 = 1

// So:

// 1 + 1 = 10
// write 0
// carry 1
// Iteration 3
// bitA = 0
// bitB = 0
// carry = 1
// sum = 0 + 0 + 1 = 1

// Current bit:

// 1 % 2 = 1

// Carry:

// 1 / 2 = 0

// So:

// 0 + 0 + carry(1) = 1
// write 1
// carry 0
// Final Result

// Before reverse:

// 10101

// After reverse:

// 10101

// Output:

// "10101"
// Interview One-Liner
// Traverse both strings from right to left, add corresponding bits with carry,
// store sum%2 as the current bit, update carry as sum/2, and finally reverse
// the result.