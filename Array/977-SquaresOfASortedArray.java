//Problem
    
    /*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
    
     
    
    Example 1:
    
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
    Example 2:
    
    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]
     
    
    Constraints:
    
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
     
    
    Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?*/

//Solution

class Solution {
    public int[] sortedSquares(int[] nums) {
        int fps = 0;

        while( fps < nums.length && nums[fps] < 0){
            fps++;
        }

        int j = fps - 1;

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(j >= 0 && fps < nums.length  && Math.pow(nums[j], 2) < Math.pow(nums[fps], 2)){
                ans[i] = (int)Math.pow(nums[j--], 2);
            } else if (fps < nums.length){
                ans[i] = (int)Math.pow(nums[fps++], 2);
            } else {
                ans[i] = nums[j] * nums[j];
                j--;
            }
        }

        return ans;
    }
}
