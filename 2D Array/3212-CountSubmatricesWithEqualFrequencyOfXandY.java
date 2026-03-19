//Problem
    
    /*Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:
    
    grid[0][0]
    an equal frequency of 'X' and 'Y'.
    at least one 'X'.
     
    
    Example 1:
    
    Input: grid = [["X","Y","."],["Y",".","."]]
    
    Output: 3
    
    Explanation:
    
    
    
    Example 2:
    
    Input: grid = [["X","X"],["X","Y"]]
    
    Output: 0
    
    Explanation:
    
    No submatrix has an equal frequency of 'X' and 'Y'.
    
    Example 3:
    
    Input: grid = [[".","."],[".","."]]
    
    Output: 0
    
    Explanation:
    
    No submatrix has at least one 'X'.
    
     
    
    Constraints:
    
    1 <= grid.length, grid[i].length <= 1000
    grid[i][j] is either 'X', 'Y', or '.'.*/

//Solution

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] sumX = new int[n][m];
        int[][] sumY = new int[n][m];

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = grid[i][j];
                if(ch == 'X'){
                    sumX[i][j] += 1;
                } else if (ch == 'Y'){
                    sumY[i][j] += 1;
                }
                if( i > 0){
                    sumX[i][j] += sumX[i-1][j];
                    sumY[i][j] += sumY[i-1][j];
                }

                if(j > 0){
                    sumX[i][j] += sumX[i][j-1];
                    sumY[i][j] += sumY[i][j-1];
                }

                if(i > 0 && j > 0){
                    sumX[i][j] -= sumX[i-1][j-1];
                    sumY[i][j] -= sumY[i-1][j-1];
                }

                if(sumX[i][j] == sumY[i][j] && sumX[i][j] > 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
