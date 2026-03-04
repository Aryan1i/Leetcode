//Problem

    /*Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.
    
    A grid is said to be valid if all the cells above the main diagonal are zeros.
    
    Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
    
    The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).
    
     
    
    Example 1:
    
    
    Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
    Output: 3
    Example 2:
    
    
    Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
    Output: -1
    Explanation: All rows are similar, swaps have no effect on the grid.
    Example 3:
    
    
    Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
    Output: 0
     
    
    Constraints:
    
    n == grid.length == grid[i].length
    1 <= n <= 200
    grid[i][j] is either 0 or 1*/

//Solution

class Solution {
    public int minSwaps(int[][] grid) {
        int[] trailing = new int[grid.length];
        Arrays.fill(trailing, grid.length + 1);

        for(int i = 0; i < grid.length; i++){
            int z = 0;
            for(int j = grid[0].length - 1; j >= 0 && grid[i][j] == 0; j--){
                z++;
            }
            trailing[i] = z;
        }

        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            int required = grid.length - i - 1;
            int j = i;
            while(j < grid.length && trailing[j] < required){
                j++;
            }

            if(j == grid.length){
                return -1;
            }

            while(j > i){
                int temp = trailing[j];
                trailing[j] = trailing[j-1];
                trailing[j-1] = temp;
                j--;
                ans++;
            }
        }

        return ans;
    }
}
