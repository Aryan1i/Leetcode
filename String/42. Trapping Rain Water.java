//Problem
    
    /*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    
     
    
    Example 1:
    
    
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    Example 2:
    
    Input: height = [4,2,0,3,2,5]
    Output: 9
     
    
    Constraints:
    
    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105*/

//Solution

class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] phh = new int[n];
        int[] nhh = new int[n];

        phh[0] = 0;
        nhh[n - 1] = 0;

        int ph = height[0];
        for(int i = 1; i < n; i++){
            if(height[i - 1] > ph){
                ph = height[i - 1];
            }
            phh[i] = ph;
        }

        int nh = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(height[i + 1] > nh) nh = height[i + 1];
            nhh[i] = nh;
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            int h = Math.min(phh[i] , nhh[i]) - height[i];
            if(h <= 0) continue;
            ans += h;
        }

        return ans;
    }
}
