//Problem
    
    /*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    
    Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
    
    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
    
     
    
    Example 1:
    
    
    Input: n = 4
    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
    Example 2:
    
    Input: n = 1
    Output: [["Q"]]
     
    
    Constraints:
    
    1 <= n <= 9*/

//Solution

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] mat = new char[n][n];
        for(char[] m : mat){
            Arrays.fill(m, '.');
        }

        queen(0, n, mat, ans);

        return ans;
    }

    public void queen(int i, int n, char[][] mat, List<List<String>> ans){

        if(i == n){
            ans.add(new ArrayList<>());
            for(char[] arr : mat){
                ans.get(ans.size() - 1).add(new String(arr));
            }
            return;
        }

        for(int j = 0; j < n; j++){
            if(valid(i, j, mat)){
                mat[i][j] = 'Q';
                queen(i + 1, n, mat, ans);
                mat[i][j] = '.';
            }
        }
    }

    public boolean valid(int i , int j , char[][] mat){
        for(int k = 0; k < i; k++){
            if(mat[k][j] == 'Q') return false;
        }

        int x = i;
        int y = j;

        while(x >= 0 && y >= 0){
            if(mat[x][y] == 'Q') return false;
            x--;
            y--;
        }

        x = i;
        y = j;

        while(x >= 0 && y < mat.length){
            if(mat[x][y] == 'Q') return false;
            x--;
            y++;
        }

        return true;
    }
}
