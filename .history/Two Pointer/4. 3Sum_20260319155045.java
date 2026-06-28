import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        int sum = 0;

        List<List<Integer>> threeSum = new ArrayList<>(); // added result list

        Arrays.sort(nums); // required for two pointer

        for(int i = 0; i < n - 2; i++)
        {
            //a = nums for understanding
            if(i > 0 && nums[i] == nums[i - 1]) //used to select the a[i]/ nums[i]
            {
                continue;
            }

            int left = i + 1; //select left and right in remaining array in every iteration of two sum 
            int right = n - 1;

            sum = -1 * nums[i]; //select a[i](-1*a[i])in every iteration of two sum 

            //two sum logic
            while(left < right)
            {
                int s = nums[left] + nums[right];

                if(sum == s)
                {
                    //adding triplet
                    threeSum.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    //duplicate condition
                    while(left < right && nums[left] == nums[left - 1])
                    {
                        left++;
                    }

                    while(left < right && nums[right] == nums[right + 1])
                    {
                        right--;
                    }
                }
                else if (s < sum)
                {
                    left++;
                }
                else 
                {
                    right--;
                }
            }
        }

        return threeSum; //return triplet
    }
}