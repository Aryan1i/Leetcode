//Problem

    /*You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
    
    Return the sum of all the unique elements of nums.
    
     
    
    Example 1:
    
    Input: nums = [1,2,3,2]
    Output: 4
    Explanation: The unique elements are [1,3], and the sum is 4.
    Example 2:
    
    Input: nums = [1,1,1,1,1]
    Output: 0
    Explanation: There are no unique elements, and the sum is 0.
    Example 3:
    
    Input: nums = [1,2,3,4,5]
    Output: 15
    Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
     
    
    Constraints:
    
    1 <= nums.length <= 100
    1 <= nums[i] <= 100*/

//Solution

class Solution {
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int ans = 0; 

        Arrays.sort(nums);
        if(nums[0] != nums[1]) ans+=nums[0];
        if(nums[n-1] != nums[n-2]) ans+=nums[n-1];
        for(int i = 1; i < n - 1; i++){
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                ans+=nums[i];
            }
        }

        return ans;
    }
}
