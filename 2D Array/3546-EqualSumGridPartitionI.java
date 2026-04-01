//Problem
    
    /*You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:
    
    Each of the two resulting sections formed by the cut is non-empty.
    The sum of the elements in both sections is equal.
    Return true if such a partition exists; otherwise return false.
    
     
    
    Example 1:
    
    Input: grid = [[1,4],[2,3]]
    
    Output: true
    
    Explanation:
    
    
    
    A horizontal cut between row 0 and row 1 results in two non-empty sections, each with a sum of 5. Thus, the answer is true.
    
    Example 2:
    
    Input: grid = [[1,3],[2,4]]
    
    Output: false
    
    Explanation:
    
    No horizontal or vertical cut results in two non-empty sections with equal sums. Thus, the answer is false.
    
     
    
    Constraints:
    
    1 <= m == grid.length <= 105
    1 <= n == grid[i].length <= 105
    2 <= m * n <= 105
    1 <= grid[i][j] <= 105*/

//Solution

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long[] horiS = new long[grid.length];
        long[] horiE = new long[grid.length];

        long[] verS = new long[grid[0].length];
        long[] verE = new long[grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                horiS[i] += grid[i][j];
            }
            if(i > 0){
                horiS[i] += horiS[i-1];
            }
        }

        for(int i = grid.length - 1; i >= 0; i--){
            for(int j =  grid[0].length-1; j >=0 ; j--){
                horiE[i] += grid[i][j];
            }
            if(i < grid.length - 1){
                horiE[i] += horiE[i+1];
            }
        }

        for(int i = 0; i < grid.length - 1; i++){
            if(horiS[i]==horiE[i+1]) return true;
        }


        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0 ; j < grid.length; j++){
                verS[i] += grid[j][i];
            }
            if(i > 0){
                verS[i] += verS[i-1];
            }
        }

        for(int i = grid[0].length - 1; i >= 0; i--){
            for(int j =  grid.length - 1; j >=0 ; j--){
                verE[i] += grid[j][i];
            }
            if(i < grid[0].length - 1){
                verE[i] += verE[i+1];
            }
        }

        for(int i = 0; i < grid[0].length - 1; i++){
            if(verS[i]==verE[i+1]) return true;
        }

        return false;
    }
}
