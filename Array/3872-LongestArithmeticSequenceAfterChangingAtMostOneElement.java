//Problem
    
    /*You are given an integer array nums.
    
    A subarray is arithmetic if the difference between consecutive elements in the subarray is constant.
    
    You can replace at most one element in nums with any integer. Then, you select an arithmetic subarray from nums.
    
    Return an integer denoting the maximum length of the arithmetic subarray you can select.
    
     
    
    Example 1:
    
    Input: nums = [9,7,5,10,1]
    
    Output: 5
    
    Explanation:
    
    Replace nums[3] = 10 with 3. The array becomes [9, 7, 5, 3, 1].
    Select the subarray [9, 7, 5, 3, 1], which is arithmetic because consecutive elements have a common difference of -2.
    Example 2:
    
    Input: nums = [1,2,6,7]
    
    Output: 3
    
    Explanation:
    
    Replace nums[0] = 1 with -2. The array becomes [-2, 2, 6, 7].
    Select the subarray [-2, 2, 6, 7], which is arithmetic because consecutive elements have a common difference of 4.
     
    
    Constraints:
    
    4 <= nums.length <= 105
    1 <= nums[i] <= 105*/

//Solution

class Solution {
    public int longestArithmetic(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 2);
        Arrays.fill(right, 2);

        int ans = 2;

        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                left[i] = left[i-1] + 1;
            }
            ans = Math.max(ans, left[i]);
        }

        for(int i = n-3; i >= 0; i--){
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){
                right[i] = right[i+1] + 1;
            }
            ans = Math.max(ans, right[i]);
        }

        for(int i = 0; i < n; i++){

            if(i > 0)
                ans = Math.max(ans, left[i-1] + 1);

            if(i < n-1)
                ans = Math.max(ans, right[i+1] + 1);

            if(i > 0 && i < n-1){

                int d = nums[i+1] - nums[i-1];

                if(d % 2 == 0){

                    int diff = d / 2;
                    int l = 1, r = 1;

                    if(i >= 2 && nums[i-1] - nums[i-2] == diff)
                        l = left[i-1];

                    if(i+2 < n && nums[i+2] - nums[i+1] == diff)
                        r = right[i+1];

                    ans = Math.max(ans, l + r + 1);
                }
            }
        }

        return ans;
    }
}
