    //Problem
    
    /*You are given a 0-indexed integer array nums. There exists an array arr of length nums.length, where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i. If there is no such j, set arr[i] to be 0.
    
    Return the array arr.
    
     
    
    Example 1:
    
    Input: nums = [1,3,1,1,2]
    Output: [5,0,3,4,0]
    Explanation: 
    When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5. 
    When i = 1, arr[1] = 0 because there is no other index with value 3.
    When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3. 
    When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4. 
    When i = 4, arr[4] = 0 because there is no other index with value 2. 
    
    Example 2:
    
    Input: nums = [0,5,3]
    Output: [0,0,0]
    Explanation: Since each element in nums is distinct, arr[i] = 0 for all i.
     
    
    Constraints:
    
    1 <= nums.length <= 105
    0 <= nums[i] <= 109
     
    
    Note: This question is the same as 2121: Intervals Between Identical Elements.*/

//Solution

class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,Long> fre = new HashMap<>();
        HashMap<Integer,Long> sum = new HashMap<>();

        long[] ans = new long[nums.length];

        for(int i = 0; i < nums.length; i++){

            if(fre.containsKey(nums[i])){
                ans[i] += fre.get(nums[i]) * i - sum.get(nums[i]);
                fre.put(nums[i],fre.get(nums[i]) + 1);
                sum.put(nums[i],sum.get(nums[i]) + i);
            } else {
                fre.put(nums[i], 1L);
                sum.put(nums[i], (long)i);
            }
        }

        fre.clear();
        sum.clear();

        for(int i = nums.length - 1; i >= 0; i--){
            if(fre.containsKey(nums[i])){
                ans[i] +=  sum.get(nums[i]) - fre.get(nums[i]) * i;
                fre.put(nums[i],fre.get(nums[i]) + 1);
                sum.put(nums[i],sum.get(nums[i]) + i);
            } else {
                fre.put(nums[i], 1L);
                sum.put(nums[i], (long)i);
            }
        }


        return ans;
    }
}
