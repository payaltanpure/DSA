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
        {
           if(colors[i]!=colors[n-1])  //compare first element with element from last
           {
              max= Math.max(max, n-1-i);
              break;
           }
        }

        for(int j=n-1;j>=0;j--)
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
