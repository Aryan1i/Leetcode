//Problem
    
    /*You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.
    
    The following proccess happens k times:
    
    Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.
    
    
    Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.
    
    
    Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.
    
     
    
    Example 1:
    
    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4
    
    Output: false
    
    Explanation:
    
    In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).
    
    
    
    Example 2:
    
    Input: mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
    
    Output: true
    
    Explanation:
    
    
    
    Example 3:
    
    Input: mat = [[2,2],[2,2]], k = 3
    
    Output: true
    
    Explanation:
    
    As all the values are equal in the matrix, even after performing cyclic shifts the matrix will remain the same.
    
     
    
    Constraints:
    
    1 <= mat.length <= 25
    1 <= mat[i].length <= 25
    1 <= mat[i][j] <= 25
    1 <= k <= 50*/

//Solution

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        k = k % mat[0].length;

        for(int i = 0; i < mat.length; i++){
            int[] ori = mat[i].clone();
            int nk = k;
            if(i % 2 == 1){
                nk = mat[0].length - nk;
            }
            reverse(mat[i] , 0 , nk - 1);
            reverse(mat[i] , nk , mat[0].length - 1 );
            reverse(mat[i] , 0 , mat[0].length - 1);

            if(cheak(ori , mat[i].clone()) == false)return false;
        }

        return true;
    }

    void reverse(int[] mat , int l , int r){
        while(l < r){
            int temp = mat[l];
            mat[l] = mat[r];
            mat[r] = temp; 
            l++;
            r--;
        }
    }

    boolean cheak(int[] arr , int[] mat){
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != mat[i]){
                return false;
            }
        }
        return true;
    }
}
