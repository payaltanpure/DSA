// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {  //tracks rows i=tracks no of rows wanted
            
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) { //j tracks the value 
                
                if (j == 0 || j == i) { //track values in row 
                    row.add(1); //if position is first or last in a row insert 1 
                } else { //if position is at middle calculate the value bu summing two previous values in previow row
                    int value = result.get(i - 1).get(j - 1) 
                              + result.get(i - 1).get(j);
                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }
}


// Algorithm: Generate Pascal’s Triangle
// Input:
// Integer numRows
// Output:
// List of lists containing Pascal’s Triangle
// Steps:
// Start
// Create an empty list result to store all rows

// For i = 0 to numRows - 1 do:

// a. Create an empty list row

// b. For j = 0 to i do:

// If j == 0 OR j == i
// → Add 1 to row

// Else
// → Compute value:

// value = result[i-1][j-1] + result[i-1][j]

// → Add value to row

// c. Add row to result

// End For loop
// Return result
// Stop
// 🧠 Key Formula

// T[i][j]=T[i−1][j−1]+T[i−1][j]

// 👉 Used only for middle elements

// Let’s do a clear dry run of the algorithm for:

// 📌 Input:
// numRows = 5
// 🔁 Step-by-Step Dry Run
// 🔹 Step 1:
// result = []
// 🔹 Iteration i = 0
// Create new row → row = []

// Loop j from 0 to 0:

// j = 0 → first/last → add 1
// row = [1]
// result = [[1]]
// 🔹 Iteration i = 1
// Create new row → row = []

// Loop j from 0 to 1:

// j = 0 → add 1
// j = 1 → add 1
// row = [1, 1]
// result = [[1], [1,1]]
// 🔹 Iteration i = 2
// Create new row → row = []
// Previous row = [1,1]

// Loop j from 0 to 2:

// j = 0 → add 1
// j = 1 → 1 + 1 = 2
// j = 2 → add 1
// row = [1, 2, 1]
// result = [[1], [1,1], [1,2,1]]
// 🔹 Iteration i = 3
// Create new row → row = []
// Previous row = [1,2,1]

// Loop j from 0 to 3:

// j = 0 → add 1
// j = 1 → 1 + 2 = 3
// j = 2 → 2 + 1 = 3
// j = 3 → add 1
// row = [1, 3, 3, 1]
// result = [[1], [1,1], [1,2,1], [1,3,3,1]]
// 🔹 Iteration i = 4
// Create new row → row = []
// Previous row = [1,3,3,1]

// Loop j from 0 to 4:

// j = 0 → add 1
// j = 1 → 1 + 3 = 4
// j = 2 → 3 + 3 = 6
// j = 3 → 3 + 1 = 4
// j = 4 → add 1
// row = [1, 4, 6, 4, 1]
// result = [[1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1]]
// ✅ Final Output
// [
//  [1],
//  [1,1],
//  [1,2,1],
//  [1,3,3,1],
//  [1,4,6,4,1]
// ]