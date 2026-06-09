//Problem
    
    /*Given an integer array nums, return the number of reverse pairs in the array.
    
    A reverse pair is a pair (i, j) where:
    
    0 <= i < j < nums.length and
    nums[i] > 2 * nums[j].
     
    
    Example 1:
    
    Input: nums = [1,3,2,3,1]
    Output: 2
    Explanation: The reverse pairs are:
    (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
    (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
    Example 2:
    
    Input: nums = [2,4,3,5,1]
    Output: 3
    Explanation: The reverse pairs are:
    (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
    (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
    (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
     
    
    Constraints:
    
    1 <= nums.length <= 5 * 104
    -231 <= nums[i] <= 231 - 1*/

//Solution

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int l, int h){
        if(l == h) return 0;

        int mid = (l + h) / 2;

        int count = 0;

        count += mergeSort(nums, l , mid);
        count += mergeSort(nums, mid + 1, h);
        count += merge(nums, l , mid, h);

        return count;
    }

    public int merge(int[] nums, int l, int mid, int h){
        int n = mid - l + 1;
        int m = h - mid;
        int[] L = new int[n];
        int[] R = new int[m];

        for(int i = l; i <= mid; i++){
            L[i - l] = nums[i];
        }

        for(int i = mid + 1; i <= h; i++){
            R[i - (mid + 1)] = nums[i];
        }

        int ans = 0;

        int x = 0;

        for(int i = 0; i < n; i++){
            while(x < m){
                if((long)L[i] > (long) 2 * R[x]){
                    x++;
                }else {
                    break;
                }
            }
            ans += x;
        }

        int i = 0, j = 0, k = l;

        while(i < n && j < m){
            if(L[i] < R[j]){
                nums[k++] = L[i++];
            }else{
                nums[k++] = R[j++];
            }
        }

        while(i < n){
            nums[k++] = L[i++];
        }

        while(j < m){
            nums[k++] = R[j++];
        }

        return ans;
    }
}
