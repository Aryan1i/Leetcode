//Problem
    
    /*You are given an integer n and a string s of length n consisting of digits.
    
    The dial contains the digits 0 through 9 in order and is circular, so 0 and 9 are adjacent. The pointer initially points to 0.
    
    To dial each digit of s in order, rotate the pointer until it points to that digit. Each rotation moves the pointer to an adjacent digit, and you may rotate in either direction. Dialing a digit that the pointer already points to requires no rotations.
    
    Before dialing, you may perform the following operation at most once:
    
    Choose an index k such that 0 <= k < n and reverse the suffix s[k..n - 1].
    Return the minimum total number of rotations needed to dial the string after optimally choosing whether to perform the operation and which suffix to reverse.
    
     
    
    Example 1:
    
    Input: n = 4, s = "1502"
    
    Output: 9
    
    Explanation:
    
    Reverse the suffix starting at k = 1 to obtain "1205", then dial it.
    
    Step	From	To	Rotations
    1	0	1	1
    2	1	2	1
    3	2	0	2
    4	0	5	5
    The total is 1 + 1 + 2 + 5 = 9, which is the minimum total number of rotations.
    
    Example 2:
    
    Input: n = 4, s = "2916"
    
    Output: 12
    
    Explanation:
    
    Choose not to reverse a suffix and dial "2916".
    
    Step	From	To	Rotations
    1	0	2	2
    2	2	9	3
    3	9	1	2
    4	1	6	5
    The total is 2 + 3 + 2 + 5 = 12, which is the minimum total number of rotations.
    
    Example 3:
    
    Input: n = 4, s = "4219"
    
    Output: 6
    
    Explanation:
    
    Reverse the suffix starting at k = 0, which reverses the entire string, to obtain "9124", then dial it.
    
    Step	From	To	Rotations
    1	0	9	1
    2	9	1	2
    3	1	2	1
    4	2	4	2
    The total is 1 + 2 + 1 + 2 = 6, which is the minimum total number of rotations.
    
     
    
    Constraints:
    
    1 <= n == s.length <= 105​​​​​​​
    s consists only of digits '0' to '9'*/

//Solution

class Solution {
    public int minRotations(int n, String s) {
        int[] pcost = new int[s.length()];

        pcost[0] = Math.min(Math.abs('0' - s.charAt(0)), 10 - Math.abs('0' - s.charAt(0)));
 
        for(int i = 1; i < n; i++){
            int ch1 = s.charAt(i) - '0';
            int ch2 = s.charAt(i - 1) - '0';
            pcost[i] = pcost[i - 1] +  Math.min(Math.abs(ch2 - ch1), 10 - Math.abs(ch2 - ch1));
        }

        int[] scost = new int[s.length()];

        for(int i = s.length() - 2; i >= 0; i--){
            int ch1 = s.charAt(i) - '0';
            int ch2 = s.charAt(i + 1) - '0';
            scost[i] = scost[i + 1] +  Math.min(Math.abs(ch2 - ch1), 10 - Math.abs(ch2 - ch1));
        }

        long ans = pcost[s.length() - 1];

        for(int i = 0; i < s.length(); i++){
            long c = 0;
            if(i > 0){
                c = pcost[i - 1];
            }
            char ch = (i == 0) ? '0' : s.charAt(i - 1);

            c += Math.min(Math.abs(ch - s.charAt(s.length() - 1)), 10 - Math.abs(ch - s.charAt(s.length() - 1)));
            c += scost[i];

            ans = Math.min(ans, c);
        }

        return (int) ans;
    }
}
