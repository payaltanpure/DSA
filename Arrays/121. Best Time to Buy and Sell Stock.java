You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


// class Solution {
//     public int maxProfit(int[] prices) {
//         int minprice= Integer.MAX_VALUE;
//         int maxprofit=0;

//         for(int i=0;i<prices.length;i++)
//         {
//             if(prices[i]<minprice)
//             {
//                 minprice=prices[i];
//                 //sets buying price least price among all array elements
//                  //used to find better day to buy stock , better day is the day when array no is min from all the array elements , find the min element and then calculate profit in else block with that min element means that min element will be the day for buying the stock with least no 
//             }
//             else
//             {
//                 int profit= prices[i]- minprice;  
//                 //  profit = selling price - buying price 
//                 //calculate profit for the day(means array element) that day will be min element from all the array elements(why min element means that day is of buying stock with least price), we use formula selling price - buying price 
//                 maxprofit= Math.max(maxprofit, profit);//check maxprofit among the profit calulated above 
//             }
//         }
//         return maxprofit;
//     }
// }

// | Day | Price | minPrice (buy) | If sell today → profit | maxProfit |
// | --- | ----- | -------------- | ---------------------- | --------- |
// | 0   | 7     | 7              | 0                      | 0         |
// | 1   | 1     | 1 (better buy) | 0                      | 0         |
// | 2   | 5     | 1              | 5 - 1 = 4              | 4         |
// | 3   | 3     | 1              | 3 - 1 = 2              | 4         |
// | 4   | 6     | 1              | 6 - 1 = 5              | 5         |
// | 5   | 4     | 1              | 4 - 1 = 3              | 5         |