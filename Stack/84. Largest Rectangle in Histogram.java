//Problem
    
    /*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
    
     
    
    Example 1:
    
    
    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.
    Example 2:
    
    
    Input: heights = [2,4]
    Output: 4
     
    
    Constraints:
    
    1 <= heights.length <= 105
    0 <= heights[i] <= 104*/

//Soltion

class Solution {
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
