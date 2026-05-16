//Problem
    
    /*Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    
    A subarray is a contiguous non-empty sequence of elements within an array.
    
     
    
    Example 1:
    
    Input: nums = [1,1,1], k = 2
    Output: 2
    Example 2:
    
    Input: nums = [1,2,3], k = 3
    Output: 2
     
    
    Constraints:
    
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107*/

//Solution

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        
        int sum = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            int rsum = sum - k;

            if(mp.containsKey(rsum)) ans += mp.get(rsum);

            mp.put(sum , mp.getOrDefault(sum,0) + 1);
        }

        return ans;
    }
}
