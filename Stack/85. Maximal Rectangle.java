//Problem
    
    /*Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
    
     
    
    Example 1:
    
    
    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 6
    Explanation: The maximal rectangle is shown in the above picture.
    Example 2:
    
    Input: matrix = [["0"]]
    Output: 0
    Example 3:
    
    Input: matrix = [["1"]]
    Output: 1
     
    
    Constraints:
    
    rows == matrix.length
    cols == matrix[i].length
    1 <= rows, cols <= 200
    matrix[i][j] is '0' or '1'.*/

//Solution

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mat = new int[m][n];
        for(int i = 0; i < matrix[0].length; i++){
            int c = 0;
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] == '0'){
                    c = 0;
                } else {
                    c++;
                }
                mat[j][i] = c;
            }
        }

        int maxArea = 0;

        for(int i = 0; i < matrix.length; i++){
            maxArea = Math.max(maxArea,largestRectangleArea(mat[i]));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        ArrayList<Integer> lse = new ArrayList<>();

        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                lse.add(-1);
            } else {
                lse.add(st.peek());
            }
            st.push(i);
        }

        st = new Stack<>();
        ArrayList<Integer> nse = new ArrayList<>();

        for(int i = heights.length - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nse.add(heights.length);
            } else {
                nse.add(st.peek());
            }
            st.push(i);
        }

        Collections.reverse(nse);

        int ans = 0;

        for(int i = 0; i < heights.length; i++){
            int width = nse.get(i) - (lse.get(i) + 1);
            int height = heights[i];

            ans = Math.max(ans, width * height);
        }

        return ans;
    }
}
