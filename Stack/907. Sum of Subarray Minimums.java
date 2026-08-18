//Problem
    
    /*Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
    
     
    
    Example 1:
    
    Input: arr = [3,1,2,4]
    Output: 17
    Explanation: 
    Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    Sum is 17.
    Example 2:
    
    Input: arr = [11,81,94,43,3]
    Output: 444
     
    
    Constraints:
    
    1 <= arr.length <= 3 * 104
    1 <= arr[i] <= 3 * 104*/

//Solution

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int M = 1000000007;

        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        st = new Stack<>();

        int[] pse = new int[n];

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;

        for(int i = 0; i < n; i++){
            ans = ( ans + (long)(i - pse[i]) * (nse[i] - i) * arr[i]) % M;
        }

        return (int)ans;
    }
}
