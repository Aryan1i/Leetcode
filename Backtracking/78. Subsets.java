//Problem
    
    /*Given an integer array nums of unique elements, return all possible subsets (the power set).
    
    The solution set must not contain duplicate subsets. Return the solution in any order.
    
     
    
    Example 1:
    
    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    Example 2:
    
    Input: nums = [0]
    Output: [[],[0]]
     
    
    Constraints:
    
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.*/

//Solution

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(0, nums,new ArrayList<>(), ans);

        return ans;
    }

    public void solve(int i, int[] nums,List<Integer> curr, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        solve(i + 1, nums, curr, ans);
        curr.add(nums[i]);
        solve(i + 1, nums, curr, ans);
        curr.remove(curr.size() - 1);
    }
}
