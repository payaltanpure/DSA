// 977. Squares of a Sorted Array
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        List <Integer> neg = new ArrayList<>();
        List <Integer> pos = new ArrayList<>();
        //seperated arrays into postive and negativetwo arrays
        for(int num: nums)
        {
            if(num<0)
            {
                neg.add(num);
            }
            else
            {
                pos.add(num);
            }
        }

        //if array has only positive elements
        if(neg.size()==0)
        {
            for(int i=0; i<pos.size(); i++)
            {
                pos.set(i,pos.get(i)*pos.get(i));
            }
            return pos.stream().mapToInt(Integer::intValue).toArray();
        }

        //if arraay has only negative elements
       if(pos.size()==0)
        {
            for(int i=0; i<neg.size(); i++)
            {
                neg.set(i,neg.get(i)*neg.get(i));
               
            }
             Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        }

        //if array has both positive and negative elements
        int i=0, j=0, id=0, n1=neg.size(), n2=pos.size();
        int res[]= new int[n1+n2];
        //square negative array 
        for(i=0; i<n1;i++)
        {
            neg.set(i,neg.get(i)*neg.get(i));
            
        }
        Collections.reverse(neg);
        //square positive array
        for(i=0; i<n2;i++)
        {
            pos.set(i,pos.get(i)*pos.get(i));
        }
        //merge two above arrays now
        i=0;
         j=0;
        while(i<n1 && j<n2)
        {
            if(neg.get(i)<=pos.get(j))
            {
                res[id]= neg.get(i);
                id++;
                i++;
               // res[id++]= neg.get(i++);
            }
            else
            {
                res[id]= pos.get(j);
                id++;
                j++;
                // res[id++]= pos.get(j++);
            }
        }

        //if any one array elements finish and other array has elements left to put in result array
        while(i<n1) //negative array has elements left
        {
                res[id]= neg.get(i);
                id++;
                i++;
               // res[id++]= neg.get(i++); 
        }

        while(j<n2) //postive array has elements left
        {
                res[id]= pos.get(j);
                id++;
                j++;
                // res[id++]= pos.get(j++);  
        }
      return res;


    }
}