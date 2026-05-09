//Problem
    
    /*You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.
    
    The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:
    
    
    
    A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:
    
    
    Return the matrix after applying k cyclic rotations to it.
    
     
    
    Example 1:
    
    
    Input: grid = [[40,10],[30,20]], k = 1
    Output: [[10,20],[40,30]]
    Explanation: The figures above represent the grid at every state.
    Example 2:
    
    
    Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
    Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
    Explanation: The figures above represent the grid at every state.
     
    
    Constraints:
    
    m == grid.length
    n == grid[i].length
    2 <= m, n <= 50
    Both m and n are even integers.
    1 <= grid[i][j] <= 5000
    1 <= k <= 109*/

//Solution

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for(int layer = 0; layer < layers; layer++){
            ArrayList<Integer> list = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            for (int j = left; j <= right; j++)
                list.add(grid[top][j]);

            for (int i = top + 1; i <= bottom; i++)
                list.add(grid[i][right]);

            for (int j = right - 1; j >= left; j--)
                list.add(grid[bottom][j]);

            for (int i = bottom - 1; i > top; i--)
                list.add(grid[i][left]);

            int len = list.size();
            int rot = k % len;

            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                temp.add(list.get((i + rot) % len));
            }

            int idx = 0;

            for (int j = left; j <= right; j++)
                grid[top][j] = temp.get(idx++);

            for (int i = top + 1; i <= bottom; i++)
                grid[i][right] = temp.get(idx++);

            for (int j = right - 1; j >= left; j--)
                grid[bottom][j] = temp.get(idx++);

            for (int i = bottom - 1; i > top; i--)
                grid[i][left] = temp.get(idx++);
        }

        return grid;
    }
}
