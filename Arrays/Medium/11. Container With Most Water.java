// 11. Container With Most Water
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

// Example 1:

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1

// simple logic calculate width using indices and height using array element at that index more the height , then more the water can be storred , so take the max array eelement as height in every iteration 
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;

        while (left < right) {
            int width = right - left; // find width , to find width we need indices of array elements left and right
            int height1 = Math.min(height[left], height[right]); // find height , take min height of line becoz if taken
                                                                 // max water will over flow, to find height we need
                                                                 // array elements
            int area = width * height1;

            maxarea = Math.max(maxarea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            // We always move the pointer pointing to the smaller height because:

            // Width will decrease no matter what.
            // To compensate, we need a chance to increase the minimum height.
            // Only the shorter line limits the water.
            // Moving the taller line cannot improve the minimum height.
        }

        return maxarea;
    }
}

// Problem Statement Explanation: Container With Most Water

// You are given an array height[].

// Each element in the array represents the height of a vertical line drawn on
// the x-axis.

// For example:

// height = [1,8,6,2,5,4,8,3,7]

// Means:

// At index 0, height = 1
// At index 1, height = 8
// At index 2, height = 6
// At index 3, height = 2
// ...
// At index 8, height = 7
// Visual Representation
// Index: 0 1 2 3 4 5 6 7 8
// Height: [1,8,6,2,5,4,8,3,7]

// Each index is a vertical line.

// 8 | | |
// 7 | | | |
// 6 | | | | |
// 5 | | | | | |
// 4 | | | | | | |
// 3 | | | | | | | |
// 2 | | | | | | | | |
// 1 | | | | | | | | | | |
// 0 +----------------------------
// 0 1 2 3 4 5 6 7 8
// Goal

// Choose two lines such that they form a container that can hold the maximum
// amount of water.

// The container is formed by:

// Left line
// Right line
// X-axis (bottom)
// How Water Is Stored

// Suppose we choose:

// Left line at index 1 with height 8
// Right line at index 8 with height 7
// Width

// Distance between indices:

// 8 - 1 = 7
// Height of Water

// Water level is determined by the shorter line.

// min(8, 7) = 7
// Area
// Area = width × height
// = 7 × 7
// = 49

// So this container holds 49 units of water.

// Why Minimum Height?

// Consider two walls:

// Left height = 8
// Right height = 7

// Water cannot rise above 7 because the shorter wall will overflow.

// So effective height is:

// min(8, 7)
// Formula
// Area=(right−left)×min(height[left],height[right])
// Example 1
// height = [1,8,6,2,5,4,8,3,7]

// Best pair:

// Index 1 → 8
// Index 8 → 7

// Area:

// (8−1)×min(8,7)=7×7=49

// Output:

// 49
// Example 2
// height = [1,1]

// Only two lines exist.

// Width:

// 1

// Height:

// min(1,1) = 1

// Area:

// 1 × 1 = 1

// Output:

// 1
// Detailed Visualization of Example 1

// Using index 1 and index 8:

// Height 8 Height 7
// | |
// |<----------- width = 7 --------->|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
// ---+---------------------------------+---
// 1 8

// Water height = 7.

// Brute Force Idea

// Check every possible pair of lines.

// For each pair:

// Compute width
// Compute min height
// Compute area
// Keep maximum

// Time Complexity: O(n²)

// Optimal Idea (Two Pointers)

// Use:

// left = 0
// right = n - 1

// Calculate area.

// Then move the pointer with the smaller height.

// Why Move Smaller Height Pointer?

// Area depends on:

// Width
// Minimum height

// When we move inward, width decreases.

// To get larger area, we need a chance to increase the minimum height.

// Only moving the shorter line can possibly increase the minimum height.

// Dry Run

// For:

// [1,8,6,2,5,4,8,3,7]
// Step 1
// left = 0 (1)
// right = 8 (7)

// Area = 8 × 1 = 8

// Move left (smaller).

// Step 2
// left = 1 (8)
// right = 8 (7)

// Area = 7 × 7 = 49

// Maximum = 49

// Move right (smaller).

// Step 3
// left = 1 (8)
// right = 7 (3)

// Area = 6 × 3 = 18

// Move right.

// Continue until pointers meet.

// Final answer = 49.

// Intuition in Simple Words

// Imagine two walls and water between them.

// Wider distance means more water.
// Taller shorter wall means more water.

// We need the best combination.

// Key Points
// Width = distance between indices.
// Height = smaller of the two lines.
// Area = width × height.
// Use two pointers for O(n) solution.

// Why Move Smaller Height Pointer? i do not understood this point

// That is the most important concept in this problem, and once you understand
// it, the whole two-pointer approach becomes very easy.

// Current Area Formula

// Area=(right−left)×min(height[left],height[right])

// Area depends on:

// Width = right - left
// Smaller height = min(height[left], height[right])
// Key Observation

// When we move any pointer:

// Width always decreases.

// So if width decreases, the only way to get a larger area is if the minimum
// height increases.

// Example 1

// Suppose:

// left height = 2
// right height = 8
// width = 5

// Current area:

// Area = 5 × min(2, 8)
// = 5 × 2
// = 10

// The smaller height is 2.

// Case 1: Move the Taller Pointer (right)

// Suppose right moves to a new height 6.

// Now:

// left = 2
// right = 6
// width = 4

// Area:

// 4 × min(2, 6)
// = 4 × 2
// = 8
// Did the minimum height increase?

// No.

// It is still 2.

// Result
// Width decreased from 5 to 4.
// Minimum height stayed 2.
// Area decreased.

// So moving the taller line is useless.

// Case 2: Move the Smaller Pointer (left)

// Suppose left moves to a new height 7.

// Now:

// left = 7
// right = 8
// width = 4

// Area:

// 4 × min(7, 8)
// = 4 × 7
// = 28
// Result
// Width decreased.
// Minimum height increased from 2 to 7.
// Area increased from 10 to 28.

// This is why we move the smaller pointer.

// Real-Life Analogy

// Imagine water between two walls:

// Left wall = 2 meters
// Right wall = 8 meters

// Water can only fill to 2 meters because the shorter wall limits it.

// If you move the 8-meter wall, the water level still remains 2 meters.

// If you move the 2-meter wall and find a taller wall, water level can
// increase.

// General Proof

// Suppose:

// height[left] = 3
// height[right] = 10
// width = 7

// Current area:

// 7 × 3 = 21

// The shorter line is 3.

// If we move right pointer

// New width < 7.

// New minimum height:

// min(3, newHeight) <= 3

// So new area:

// newWidth × value <= 6 × 3 = 18

// It cannot exceed 21.

// If we move left pointer

// The new height may become larger than 3.

// For example, if new height = 9:

// new area = 6 × min(9,10)
// = 6 × 9
// = 54

// Now the area can increase.

// Simple Rule to Remember

// The shorter line is the bottleneck.

// To increase area, remove the bottleneck by moving the shorter line.

// Visual Example
// Left = 2 Right = 8
// | |
// |~~~~~~~~~~~~~~~~~~~~~~~~~~|
// |~~~~~~~~~~~~~~~~~~~~~~~~~~|
// --+--------------------------+--

// Water height is only 2.

// Moving the right wall does not help.

// Moving the left wall may find a taller wall.

// Summary Table
// Situation Move Which Pointer? Reason
// height[left] < height[right] Move left++ Left is limiting factor
// height[left] > height[right] Move right-- Right is limiting factor
// Equal heights Move either Both are limiting
// Final Intuition

// We always move the pointer pointing to the smaller height because:

// Width will decrease no matter what.
// To compensate, we need a chance to increase the minimum height.
// Only the shorter line limits the water.
// Moving the taller line cannot improve the minimum height.