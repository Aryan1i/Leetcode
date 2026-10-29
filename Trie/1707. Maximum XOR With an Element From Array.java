//Problem

    /*You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].
    
    The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.
    
    Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.
    
     
    
    Example 1:
    
    Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
    Output: [3,3,7]
    Explanation:
    1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
    2) 1 XOR 2 = 3.
    3) 5 XOR 2 = 7.
    Example 2:
    
    Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
    Output: [15,-1,5]
     
    
    Constraints:
    
    1 <= nums.length, queries.length <= 105
    queries[i].length == 2
    0 <= nums[j], xi, mi <= 109*/

//Solution

class Solution {
    class Trie{
        Trie[] children = new Trie[2];
    }

    Trie root = new Trie();

    public void insert(int n){
        Trie curr = root;

        for(int i = 30; i >= 0; i--){
            int b = (n >> i) & 1;
            if(curr.children[b] == null){
                curr.children[b] = new Trie();
            }
            curr = curr.children[b];
        }
    }

    public int maxXor(int x){
        int ans = 0;
        Trie curr = root;

        for(int i = 30; i >= 0; i--){
            int b = (x >> i) & 1;
            int c = 1 - b;

            if(curr.children[c] != null) {
                ans |= (1 << i);
                curr = curr.children[c];
            } else {
                curr = curr.children[b];
            }
        }

        return ans;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return Integer.compare(a[2], b[2]);});

        for(int i = 0; i < queries.length; i++){
            pq.offer(new int[]{i, queries[i][0], queries[i][1]});
        }

        int[] ans = new int[queries.length];

        int i = 0;

        while(pq.size() > 0){
            int[] temp = pq.remove();

            int idx = temp[0];
            int x = temp[1];
            int m = temp[2];

            while(i < nums.length && nums[i] <= m){
                insert(nums[i++]);
            }

            ans[idx] = (i == 0) ? -1 : maxXor(x);
        }

        return ans;
    }
}
