// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"

// Output: true

// Example 2:

// Input: s = "()[]{}"

// Output: true

// Example 3:

// Input: s = "(]"

// Output: false

// Example 4:

// Input: s = "([])"

// Output: true

// Example 5:

// Input: s = "([)]"

// Output: false

 

//same example like postfix and prefix exp evaluation so stack is used
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') 
            {
                stack.push(ch);
            } 
            else 
            {

                if (stack.isEmpty())  //top var not present in java to check top==0 then stack is empty
                {
                    return false;
                }

                char top = stack.peek(); //peek fetches top ele of the stack

                if ((top == '(' && ch == ')') ||
                    (top == '{' && ch == '}') ||
                    (top == '[' && ch == ']')) {

                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // return stack.isEmpty(); returns true or false it empty true and if not empty false returned
    }
}

// Algorithm
// Create an empty stack.
// Traverse each character ch in the string.
// If ch is an opening bracket ((, {, [):
// Push it into the stack.
// Otherwise (ch is a closing bracket):
// If the stack is empty, return false.
// Get the top element of the stack.
// Check whether the top opening bracket matches the current closing bracket.
// ( ↔ )
// { ↔ }
// [ ↔ ]
// If they match:
// Pop the top element.
// Otherwise:
// Return false.
// After traversing the string:
// If the stack is empty, return true.
// Otherwise, return false.

// Input: "([{}])"

// (  -> push  -> [(]
// [  -> push  -> [(, []
// {  -> push  -> [(, [, {]
// }  -> match { -> pop -> [(, []
// ]  -> match [ -> pop -> [(]
// )  -> match ( -> pop -> []

// Stack is empty -> return true


// For the Valid Parentheses problem:

// Time Complexity: O(n)
// We traverse the string once.
// Each bracket is pushed into the stack at most once and popped at most once.
// Input: "([{}])"

// ( -> push
// [ -> push
// { -> push
// } -> pop
// ] -> pop
// ) -> pop

// Total operations are proportional to n.

// Space Complexity: O(n)

// In the worst case, all characters are opening brackets:

// "((((((("

// All of them are stored in the stack.

// Stack = [( ( ( ( ( ( (]

// So the stack can hold up to n elements.

// Interview Answer
// Time Complexity  : O(n)
// Space Complexity : O(n)

// Reason: Each character is processed once, and in the worst case the stack may store all opening brackets.

// Why is Stack used in Valid Parentheses?

// A stack follows LIFO (Last In, First Out).

// In brackets, the last opening bracket must be closed first.

// Example:

// ([{}])

// Open:  ( [ {
// Close: } ] )

// The last opened bracket is {, so it must be closed first by }.

// Since Stack removes the most recently added element first, it naturally checks whether brackets are closed in the correct order.

// Applications of Stack
// 1. Valid Parentheses / Bracket Matching
// ({[]})

// Used to check correct opening and closing order.

// 2. Function Calls / Recursion

// When a function calls another function, information is stored in the call stack.

// main()
//  └─ fun1()
//      └─ fun2()

// fun2() finishes first, then fun1(), then main().

// 3. Undo/Redo Operations

// In editors like Word, VS Code.

// Type A
// Type B
// Type C

// Undo removes C first, then B, then A.

// 4. Browser Back Button
// Google
//  ↓
// YouTube
//  ↓
// LeetCode

// Back goes to:

// LeetCode → YouTube
// YouTube → Google
// 5. Infix to Postfix Conversion
// A + B * C

// Convert to:

// ABC*+

// Operators are stored in a stack according to precedence.

// 6. Infix to Prefix Conversion
// A + B * C

// Convert to:

// +A*BC

// Stack is used to manage operators and precedence.

// 7. Postfix Evaluation
// 23*5+

// Evaluation:

// 2 3 * = 6
// 6 5 + = 11

// Operands are pushed into a stack and operators pop operands for calculation.

// 8. Prefix Evaluation
// +9*26

// Evaluation:

// 2*6 = 12
// 9+12 = 21

// Stack is used while scanning from right to left.

// 9. Depth First Search (DFS)

// Graphs and Trees use a stack (explicitly or through recursion).