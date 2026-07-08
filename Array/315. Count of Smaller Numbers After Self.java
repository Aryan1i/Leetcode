//Problem
    
    /*Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].
    
     
    
    Example 1:
    
    Input: nums = [5,2,6,1]
    Output: [2,1,1,0]
    Explanation:
    To the right of 5 there are 2 smaller elements (2 and 1).
    To the right of 2 there is only 1 smaller element (1).
    To the right of 6 there is 1 smaller element (1).
    To the right of 1 there is 0 smaller element.
    Example 2:
    
    Input: nums = [-1]
    Output: [0]
    Example 3:
    
    Input: nums = [-1,-1]
    Output: [0,0]
     
    
    Constraints:
    
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
     
    */

//Solution

class Solution {

    class Pair{
        int val;
        int idx;

        Pair(int val , int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ans = new int[n];

        Pair[] arr = new Pair[n];
        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < n; i++){
            l.add(ans[i]);
        }

        return l;
    }

    public void mergeSort(Pair[] arr, int l , int r){
        if(l >= r) return;
        int m = l + (r - l) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }

    public void merge(Pair[] arr, int l,int m, int r){
        Pair[] temp = new Pair[r - l + 1];

        int i = l;
        int j = m + 1;

        int k = 0;
        int rightCount = 0;

        while(i <= m && j <= r){
            if(arr[j].val < arr[i].val){
                rightCount++;
                temp[k++] = arr[j++];
            } else {
                ans[arr[i].idx] += rightCount;
                temp[k++] = arr[i++];
            }
        }

        while(i <= m){
            ans[arr[i].idx] += rightCount;
            temp[k++] = arr[i++];
        }

        while(j <= r){
            temp[k++] = arr[j++];
        }

        for(int x = l; x <= r; x++){
            arr[x] = temp[x - l];
        }
    }
}
