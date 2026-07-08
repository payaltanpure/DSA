// 345. Reverse Vowels of a String
// Easy
// Topics
// premium lock icon
// Companies
// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

// Example 1:

// Input: s = "IceCreAm"

// Output: "AceCreIm"

// Explanation:

// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:

// Input: s = "leetcode"

// Output: "leotcede"

// Algorithm
// Convert the input string into a character array so that characters can be modified.
// Traverse the string once and count the total number of vowels.
// Create a character array vowels of size equal to the number of vowels.
// Traverse the string again.
// If the current character is a vowel (a, e, i, o, u or A, E, I, O, U), store it in the vowels array.
// Use a separate index k so that vowels are stored continuously.
// Reverse the vowels array using the swapping technique.
// Initialize two pointers:
// Left pointer at the beginning.
// Right pointer at the end.
// Swap the vowels until the pointers meet.
// Traverse the character array again.
// Whenever a vowel is encountered, replace it with the next character from the reversed vowels array.
// Increment k after each replacement.
// Convert the modified character array back into a string.
// Return the final string.

class Solution {
    public String reverseVowels(String s) {

        // // Convert the String into a character array.
        // // Mistake in your code:
        // // You tried to modify the String directly using s.charAt(i) = ...
        // // Strings are immutable in Java, so they cannot be modified.
        // char[] arr = s.toCharArray();

        // // Count how many vowels are present.
        // // Mistake in your code:
        // // You declared char[] vowels but never initialized it.
        // // We first count the vowels so we can create an array of the correct size.
        // int count = 0;

        // for (int i = 0; i < s.length(); i++) {

        // // Mistake in your code:
        // // You wrote s.charAt[i]
        // // charAt is a method, so use s.charAt(i)

        // if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
        // s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
        // s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' ||
        // s.charAt(i) == 'O' || s.charAt(i) == 'U') {

        // count++;
        // }
        // }

        // // Create the vowel array after knowing its size.
        // char[] vowels = new char[count];

        // // Store only the vowels.
        // // Mistake in your code:
        // // You stored vowels using vowels[i].
        // // That leaves empty spaces for consonants.
        // // Instead, use another index (k) to store vowels continuously.
        // int k = 0;

        // for (int i = 0; i < s.length(); i++) {

        // if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
        // s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
        // s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' ||
        // s.charAt(i) == 'O' || s.charAt(i) == 'U') {

        // vowels[k] = s.charAt(i);
        // k++;
        // }
        // }

        // // Reverse the vowel array.
        // char temp;

        // for (int i = 0; i < vowels.length / 2; i++) {

        // temp = vowels[i];
        // vowels[i] = vowels[vowels.length - 1 - i];
        // vowels[vowels.length - 1 - i] = temp;
        // }

        // // Put the reversed vowels back into the character array.
        // // Mistake in your code:
        // // You tried:
        // // s.charAt(i) = vowels[i];
        // // This is not allowed because Strings are immutable.
        // // Instead, modify the character array.
        // k = 0;

        // for (int i = 0; i < arr.length; i++) {

        // if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' ||
        // arr[i] == 'o' || arr[i] == 'u' ||
        // arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' ||
        // arr[i] == 'O' || arr[i] == 'U') {

        // arr[i] = vowels[k];
        // k++;
        // }
        // }

        // // Mistake in your code:
        // // Your method returns String but you did not return anything.
        // // Convert the character array back to a String.
        // return new String(arr);

        // optimal solution
        // If asked in an interview, you can explain the algorithm like this:
        // Convert the string into a character array.
        // Initialize two pointers: left at the beginning and right at the end.
        // Move left forward until it finds a vowel.
        // Move right backward until it finds a vowel.
        // Swap the two vowels.
        // Move both pointers inward.
        // Repeat until left >= right.
        // Convert the character array back to a string and return it.

        // Convert the String into a character array because
        // Strings are immutable in Java.
        char[] arr = s.toCharArray();

        // Two pointers
        int left = 0;
        int right = arr.length - 1;

        // Continue until the pointers meet
        while (left < right) {

            // Move the left pointer until it points to a vowel
            while (left < right && !isVowel(arr[left])) {
                left++;
            }

            // Move the right pointer until it points to a vowel
            while (left < right && !isVowel(arr[right])) {
                right--;
            }

            // Swap the vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move both pointers inward
            left++;
            right--;
        }

        // Convert the character array back to a String
        return new String(arr);
    }

    // Helper method to check whether a character is a vowel
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' ||
                ch == 'O' || ch == 'U') {
            return true;
        }

        // If the character is not a vowel
        return false;

    }
}

// | Feature | Your Solution | Optimal Solution |
// | ------------------ | ------------- | ---------------- |
// | Time Complexity | `O(n)` ✅ | `O(n)` ✅ |
// | Space Complexity | `O(v)` | `O(1)` ✅ |
// | Extra Array | Yes | No |
// | Easy to Understand | ✅ Yes | Slightly harder |
// | LeetCode Accepted | ✅ Yes | ✅ Yes |
