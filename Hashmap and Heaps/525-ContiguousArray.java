//Problem
    
    /*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
    
     
    
    Example 1:
    
    Input: nums = [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
    Example 2:
    
    Input: nums = [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
    Example 3:
    
    Input: nums = [0,1,1,1,1,1,0,0,0]
    Output: 6
    Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
     
    
    Constraints:
    
    1 <= nums.length <= 105
    nums[i] is either 0 or 1.*/

//Solution

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) sum--;
            if(nums[i] == 1) sum++;
            arr[i] = sum;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, -1);

        for(int i = 0; i < n; i++){
            if(hm.containsKey(arr[i])){
                ans = Math.max(i - hm.get(arr[i]),ans);
            } else {
                hm.put(arr[i], i);
            }
        }

        return ans;
    }
}
