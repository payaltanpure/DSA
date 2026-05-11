There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
Return the maximum distance between two houses with different colors.
The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
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

