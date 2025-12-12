//Leetcode Problem Number 16

    /*Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    
    Return the sum of the three integers.
    
    You may assume that each input would have exactly one solution.
    
     
    
    Example 1:
    
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    Example 2:
    
    Input: nums = [0,0,0], target = 1
    Output: 0
    Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
     
    
    Constraints:
    
    3 <= nums.length <= 500
    -1000 <= nums[i] <= 1000
    -104 <= target <= 104
    */

//Solution

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n= nums.length;
        int closest=Integer.MAX_VALUE;
        int closeBy=Integer.MAX_VALUE;
        
        for(int i=0;i<=n-3;i++){

            int left=i+1;
            int right=n-1;

            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                int diff=diffrence(target,sum);
                if(diff<closeBy){
                    closest=sum;
                    closeBy=diff;
                }

                if(sum<target){
                    left++;
                } else if (sum>target){
                    right--;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }

    public int diffrence(int tar,int sum){
        int diff;
        if(tar>sum){
            diff=tar-sum;
        } else {
            diff=sum-tar;
        }
        return diff;
    }
}
