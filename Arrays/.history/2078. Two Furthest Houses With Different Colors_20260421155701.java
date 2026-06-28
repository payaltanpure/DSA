// There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
// Return the maximum distance between two houses with different colors.
// The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.

//Brute Force Approach
class Solution {
    public int maxDistance(int[] colors) {

        int max_distance = Integer.MIN_VALUE;
        for (int i=0; i<colors.length;i++)
        {
            for (int j=i+1; j<colors.length;j++)
            {
    
                if(colors[i]!=colors[j])
                {
                   max_distance= Math.max(max_distance,j-i);
                }

            }
        
        }
        return max_distance;
    }
}

// Time comp: O(n2)
// space comp: O(1)

//Best Optimal Approach
class Solution {
    public int maxDistance(int[] colors) 
    {
        int max=0;
        int n = colors.length;
        for(int i=0;i<n-1;i++)
        
           if(colors[i]!=colors[n-1])  //compare elements from first  with last element
           {
              max= Math.max(max, n-1-i);
              break;
           }
        }

        for(int j=n-1;j>=0;j--)  //compare elements from last with first element
        {
            if(colors[j]!= colors[0])
            {
                max= j;
                break;
            }
        }

        return max;
    }
}

// Time comp: O(n)
// space comp: O(1)

//corrected version
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, n - 1 - i);
            }
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);
            }
        }

        return max;
    }
}



// Main difference
// First code

// Finds only:

// one house different from first
// one house different from last

breaks 
// Final code

// Checks:

// every house against first
// every house against last

// So it explores all valid end-based distances.

// Simple intuition

// Suppose many houses have same color as first and last.

// Then the best answer may come from:

// some middle house with last house
// or some middle house with first house

// If you stop early, you may miss a larger distance later.

// If you check all indices, you never miss it.

// Short answer

// Your first code was wrong because it used break, so it considered only the first mismatch found from each side, not all possible houses.
// Your final code is correct because it checks every index against both ends and takes the maximum.
