//Problem
    
    /*Given an m x n matrix, return all elements of the matrix in spiral order.
    
     
    
    Example 1:
    
    
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]
    Example 2:
    
    
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     
    
    Constraints:
    
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100*/

//Solution

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length; 
        int m = matrix[0].length;
        
        int top = 0, bottom = n-1;
        int left = 0, right = m-1;

        List<Integer> list = new ArrayList<>();

        while( left <= right && top <= bottom){
            if(left <= right ){
                for(int i = left; i <= right && matrix[top][i] != 101; i++){
                    list.add(matrix[top][i]);
                    matrix[top][i] = 101;
                }
                top++;
            }

            if(top <= bottom ){
                for(int i = top; i <= bottom && matrix[i][right] != 101; i++){
                    list.add(matrix[i][right]);
                    matrix[i][right] = 101;
                }
                right--;
            }
            

            if(left <= right ){
                for(int i = right; i >= left && matrix[bottom][i] != 101; i--){
                    list.add(matrix[bottom][i]);
                    matrix[bottom][i] = 101;
                }
                bottom--;
            }

            if(top <= bottom ){
                for(int i = bottom; i>= top && matrix[i][left] != 101; i--){
                    list.add(matrix[i][left]);
                    matrix[i][left] = 101;
                }
                left++;
            }
        }
        return list;
    }
}
