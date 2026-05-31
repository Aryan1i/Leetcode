//Problem
    
    /*You are given a 2D integer array items, where items[i] = [factori, pricei] represents the ith item. You are also given an integer budget.
    
    There are unlimited copies of each item available for purchase.You may buy any number of copies of any items such that the total cost of the purchased copies is at most budget.
    
    After buying items, you may receive free copies according to the following rules:
    
    For each item i that you bought at least one copy of, you receive one free copy of every item j such that j != i and factori divides factorj.
    Buying multiple copies of the same item i does not give additional free copies through item i.
    The same item j can be received multiple times for free if it is received from purchases of different item types.
    Return the maximum total number of item copies you can obtain, including both purchased copies and free copies, while spending at most budget on purchased items.
    
     
    
    Example 1:
    
    Input: items = [[6,2],[2,6],[3,4]], budget = 9
    
    Output: 4
    
    Explanation:
    
    You can buy 2 copies of item 0 and 1 copy of item 2 for a total cost of 2 * 2 + 4 = 8, which is not greater than budget = 9.
    Buying item 2 gives 1 free copy of item 0, because factor2 = 3 divides factor0 = 6.
    You leave with 3 purchased copies and 1 free copy, for a total of 4 item copies.
    Example 2:
    
    Input: items = [[2,4],[3,2],[4,1],[6,4],[12,4]], budget = 8
    
    Output: 10
    
    Explanation:
    
    You can buy 1 copy of item 0, 1 copy of item 1, and 2 copies of item 2 for a total cost of 4 + 2 + 2 * 1 = 8.
    Buying item 0 gives 1 free copy of items 2, 3, and 4.
    Buying item 1 gives 1 free copy of items 3 and 4.
    Buying item 2 gives 1 free copy of item 4.
    Thus, you receive 6 free copies. You leave with 4 purchased copies and 6 free copies, for a total of 10 item copies.
     
    
    Constraints:
    
    1 <= items.length <= 1000
    items[i] = [factori, pricei]
    1 <= factori, pricei <= 1500
    1 <= budget <= 1500*/

//Solution

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int MAXF = 1500;

        int[] freq = new int[MAXF + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] multipleCnt = new int[MAXF + 1];

        for (int f = 1; f <= MAXF; f++) {
            for (int m = f; m <= MAXF; m += f) {
                multipleCnt[f] += freq[m];
            }
        }

        int[] gain = new int[n];
        for (int i = 0; i < n; i++) {
            gain[i] = multipleCnt[items[i][0]] - 1;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];

            int[] take = new int[budget + 1];
            Arrays.fill(take, Integer.MIN_VALUE / 2);

            for (int b = price; b <= budget; b++) {
                take[b] = dp[b - price] + gain[i] + 1;
            }

            for (int b = price; b <= budget; b++) {
                take[b] = Math.max(take[b],
                                   take[b - price] + 1);
            }

            int[] ndp = dp.clone();

            for (int b = 0; b <= budget; b++) {
                ndp[b] = Math.max(ndp[b], take[b]);
            }

            dp = ndp;
        }

        int ans = 0;
        for (int x : dp) ans = Math.max(ans, x);

        return ans;
    }
}
