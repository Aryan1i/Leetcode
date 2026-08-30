//Problem
    
    /*You are given an integer array nums.
    
    You may remove at most one element from nums. Let arr be the array of remaining elements in their original order, and let m be its length.
    
    A split position i of arr is valid if:
    
    0 <= i < m - 1, and
    gcd(arr[0..i]) == gcd(arr[i + 1..m - 1]).
    An array of length 1 has no valid split positions.
    
    The score of arr is the number of valid split positions in it.
    
    Return the maximum possible score of arr.
    
    Here, gcd(a) denotes the greatest common divisor of all elements in the array a.
    
     
    
    Example 1:
    
    Input: nums = [10,30,15,10]
    
    Output: 2
    
    Explanation:
    
    One optimal solution is to remove nums[2] = 15. Then arr = [10, 30, 10].
    
    The split positions are:
    
    Split Position i	gcd(arr[0..i])	gcd(arr[i + 1..m - 1])
    0	10	10
    1	10	10
    All split positions are valid. Thus, the answer is 2.
    
    Example 2:
    
    Input: nums = [2,10,14]
    
    Output: 1
    
    Explanation:
    
    One optimal solution is to not remove any element. Then arr = [2, 10, 14].
    
    The split positions are:
    
    Split Position i	gcd(arr[0..i])	gcd(arr[i + 1..m - 1])
    0	2	2
    1	2	14
    Only the split position at index 0 is valid. Thus, the answer is 1.
    
    Example 3:
    
    Input: nums = [2,4]
    
    Output: 0
    
    Explanation:
    
    The only remaining array that has a split position is arr = [2, 4].
    
    The split positions are:
    
    Split Position i	gcd(arr[0..i])	gcd(arr[i + 1..m - 1])
    0	2	4
    There are no valid split positions. Thus, the answer is 0.
    
     
    
    Constraints:
    
    2 <= nums.length <= 1000
    1 <= nums[i] <= 109​​​​​​​*/

//Solution

class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        if( n == 1) return 0;
        int ans = solve(nums);

        for(int i = 0; i < n; i++){
            int[] arr = new int[n - 1];
            int j = 0;
            for(int k = 0; k < n; k++){
                if(k == i) continue;
                arr[j++] = nums[k];
            }
            ans = Math.max(ans, solve(arr));
        }
        return ans;
    }

    public int solve(int[] nums){
        int n = nums.length;
        int[] gp = new int[nums.length];
        gp[0] = nums[0];

        for(int i = 1; i < n; i++){
            gp[i] = gcd(nums[i], gp[i - 1]);
        }

        int[] gs = new int[nums.length];
        gs[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            gs[i] = gcd(gs[i + 1], nums[i]);
        }

        int c = 0;

        for(int i = 0; i < n - 1; i++){
            if(gp[i] == gs[i + 1]) c++;
        }

        return c;
    }

    public int gcd(int a , int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
