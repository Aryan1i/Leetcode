//Problem
    
    /*Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    
    The solution set must not contain duplicate subsets. Return the solution in any order.
    
     
    
    Example 1:
    
    Input: nums = [1,2,2]
    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    Example 2:
    
    Input: nums = [0]
    Output: [[],[0]]
     
    
    Constraints:
    
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10*/

//Solution

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] arr = new int[map.size()];

        int i = 0;
        for(int ele : map.keySet()){
            arr[i++] = ele;
        }

        List<List<Integer>> ans = new ArrayList<>();
        solve(0, arr,new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int idx, int[] arr, List<Integer> curr, List<List<Integer>> ans ){
        if(idx == arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        int val = map.get(arr[idx]);
        for(int i = 0; i <= val; i++){
            for(int j = 1; j <= i; j++){
                curr.add(arr[idx]); 
            }
            solve(idx + 1, arr, curr, ans);
            for(int j = 1; j <= i; j++){
                curr.remove(curr.size() - 1);
            }
        }
    }
}
