//Problem

    /*You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:
    
    answer1 : the number of indices i such that nums1[i] exists in nums2.
    answer2 : the number of indices i such that nums2[i] exists in nums1.
    Return [answer1,answer2].
    
     
    
    Example 1:
    
    Input: nums1 = [2,3,2], nums2 = [1,2]
    
    Output: [2,1]
    
    Explanation:
    
    
    
    Example 2:
    
    Input: nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
    
    Output: [3,4]
    
    Explanation:
    
    The elements at indices 1, 2, and 3 in nums1 exist in nums2 as well. So answer1 is 3.
    
    The elements at indices 0, 1, 3, and 4 in nums2 exist in nums1. So answer2 is 4.
    
    Example 3:
    
    Input: nums1 = [3,4,2,3], nums2 = [1,5]
    
    Output: [0,0]
    
    Explanation:
    
    No numbers are common between nums1 and nums2, so answer is [0,0].
    
     
    
    Constraints:
    
    n == nums1.length
    m == nums2.length
    1 <= n, m <= 100
    1 <= nums1[i], nums2[i] <= 100
     
    */

//Soluiton

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = {0,0};
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums1.length ; i++){
            if(hm.containsKey(nums1[i]) == false){
                hm.put(nums1[i],1);
            }else{
                int temp = hm.get(nums1[i]);
                hm.put(nums1[i],++temp);
            }
        }

        HashMap<Integer,Integer> hm2 = new HashMap<>();
        for(int i = 0; i < nums2.length ; i++){
            if(hm2.containsKey(nums2[i]) == false){
                hm2.put(nums2[i],1);
            }else{
                int temp = hm2.get(nums2[i]);
                hm2.put(nums2[i],++temp);
            }
        }

        for(int key : hm.keySet()){
            if(hm2.containsKey(key)){
                ans[0]= ans[0] + hm.get(key); 
            }
        }

        for(int key : hm2.keySet()){
            if(hm.containsKey(key)){
                ans[1]= ans[1] + hm2.get(key);
            }
        }
        return ans;
    }
}
