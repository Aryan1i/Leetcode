//Problem
    
    /*Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
    
     
    
    Example 1:
    
    
    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 4
    Example 2:
    
    
    Input: matrix = [["0","1"],["1","0"]]
    Output: 1
    Example 3:
    
    Input: matrix = [["0"]]
    Output: 0
     
    
    Constraints:
    
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 300
    matrix[i][j] is '0' or '1'.*/

//Solutionclass Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length; 
        int[][] arr = new int[m][n];

        for(int j = 0; j < n; j++){
            int c = 0;
            for(int i = 0; i < m ;i++){
                if(matrix[i][j] == '1') c++;
                else c = 0;
                arr[i][j]= c;
            }
        }

        int ans = 0;

        for(int[] h : arr){
            ans = Math.max(ans,largestSqure(h));
        }

        return ans;
    }

    public int largestSqure(int[] heights){
        int n = heights.length; 

        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }  

            if(st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();

            st.push(i);
        }

        int[] nse = new int[n];

        st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }  

            if(st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();

            st.push(i);
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            int side = Math.min(heights[i], nse[i] - pse[i] - 1);

            ans = Math.max(ans, side * side);
        }

        return ans;
    }
}

