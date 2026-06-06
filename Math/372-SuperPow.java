//Problem
    
    /*Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
    
     
    
    Example 1:
    
    Input: a = 2, b = [3]
    Output: 8
    Example 2:
    
    Input: a = 2, b = [1,0]
    Output: 1024
    Example 3:
    
    Input: a = 1, b = [4,3,3,8,5,2]
    Output: 1
     
    
    Constraints:
    
    1 <= a <= 231 - 1
    1 <= b.length <= 2000
    0 <= b[i] <= 9
    b does not contain leading zeros.*/

//Solution


class Solution {
    int mod = 1337;
    public int superPow(int a, int[] b) {
        return solve(a, b, b.length - 1);
    }

    public int solve(int a, int[] b, int idx){
        if(idx < 0) return 1;
        
        int p1 = pow(solve(a, b, idx - 1), 10);
        int p2 = pow(a, b[idx]);

        return (int)((long)p1 * p2 % mod);
    }

    public int pow(int a , int k){
        a %= mod;
        int res = 1;

        while (k > 0) {
            if ((k & 1) == 1) {
                res = (int)((long)res * a % mod);
            }
            a = (int)((long)a * a % mod);
            k >>= 1;
        }

        return res;
    }
}
