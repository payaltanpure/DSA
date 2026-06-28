// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

 

// Example 1:

// Input: nums = [2,2,1]

// Output: 1

// Example 2:

// Input: nums = [4,1,2,1,2]

// Output: 4



//best optimal solution
// What is XOR?

// XOR is a bitwise operator (^)

// 📌 Rules:
// 0 ^ 0 = 0  
// 1 ^ 1 = 0  
// 0 ^ 1 = 1  
// 1 ^ 0 = 1  

// 👉 Same bits → 0
// 👉 Different bits → 1

// 🧠 Most Important Properties
// a ^ a = 0
// 👉 same numbers result is 0 as no cancel out
// a ^ 0 = a
// 👉 one number and other 0 then result is the no
// XOR is commutative & associative
// a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
// 🎯 Why XOR works in this problem

// Problem says:
// 👉 Every element appears twice except one

// So:

// a ^ a = 0

// 👉 All duplicate numbers cancel each other
// 👉 Only single number remains

// 🔍 Example
// Input:
// [2, 2, 1]
// Step-by-step:
// result = 0

// result = 0 ^ 2 = 2
// result = 2 ^ 2 = 0
// result = 0 ^ 1 = 1

// 👉 Final Answer = 1

// 🔍 Another Example
// Input:
// [4, 1, 2, 1, 2]
// Step-by-step:
// 0 ^ 4 = 4
// 4 ^ 1 = 5
// 5 ^ 2 = 7
// 7 ^ 1 = 6
// 6 ^ 2 = 4

// 👉 Final Answer = 4

// 🧠 Visualization Idea

// Think:
// 👉 Pair numbers disappear
// 👉 Only unpaired number survives

// 🎯 Code
// int result = 0;
// for (int num : nums) {
//     result = result ^ num;
// }
// return result;
// ⏱ Complexity
// Time: O(n)
// Space: O(1) (best possible)
// 💡 One-line Memory Trick

// 👉

// “Same numbers cancel → unique number remains”

// ⚠️ When XOR works?

// ✔ Works when:

// Every number appears twice except one

// ❌ Does NOT work if:

// Numbers appear 3 times (different logic needed)
class Solution {
    public int singleNumber(int[] nums) {
       int result=0;

       for(int num: nums)
       {
          result=result^num;
       }
       return result;
    }
}

//brute force mylogic
// class Solution {
//     public int singleNumber(int[] nums) {

//         int[] countarr = new int[100]; // assuming range 0–99

//         for (int i = 0; i < nums.length; i++) {
//             countarr[nums[i]]++;
//         }

//         for (int i = 0; i < countarr.length; i++) {
//             if (countarr[i] == 1) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }

//brute force
// import java.util.*;

// class Solution {
//     public int singleNumber(int[] nums) {

//         Map<Integer, Integer> countarr = new HashMap<>();

//         // Count frequency
//         for (int i = 0; i < nums.length; i++) {
//             countarr.put(nums[i], countarr.getOrDefault(nums[i], 0) + 1);
//         }

//         // Find element with count = 1
//         for (int key : countarr.keySet()) {
//             if (countarr.get(key) == 1) {
//                 return key;
//             }
//         }

//         return -1; // fallback (never happens as per problem)
//     }
// }