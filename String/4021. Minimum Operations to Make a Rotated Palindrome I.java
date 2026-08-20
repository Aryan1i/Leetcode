//Problem
    
    /*You are given a string s consisting of lowercase English letters.
    
    You can perform the following operations any number of times (including zero) and in any order:
    
    Increment: Choose any index i and replace s[i] with the next lowercase English letter. The letter after 'z' is 'a'.
    Left rotate: Move the first character of the string to the end.
    Return the minimum number of operations required to make s a palindrome.
    
     
    
    Example 1:
    
    Input: s = "abc"
    
    Output: 2
    
    Explanation:
    
    One optimal solution:
    Left rotate the string: "abc" -> "bca".
    Increment 'a' to 'b': "bca" -> "bcb".
    "bcb" is a palindrome. Thus, the answer is 2.
    Example 2:
    
    Input: s = "yb"
    
    Output: 3
    
    Explanation:
    
    Increment the first character three times: "yb" -> "zb" -> "ab" -> "bb".
    "bb" is a palindrome. Thus, the answer is 3.
     
    
    Constraints:
    
    2 <= s.length <= 2000
    s consists only of lowercase English letters.*/

//Solution

class Solution {
    public int minOperations(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        int ans = Integer.MAX_VALUE;
        ans = operations(sb);
        int temp = 0;
        for(int i = 1; i < n; i++){
            temp++;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            ans = Math.min(ans, operations(sb) + temp);
        }

        return ans;
    }

    public int operations(StringBuilder sb){
        int n = sb.length();
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while(i < j){
            int chi = sb.charAt(i) - 'a';
            int chj = sb.charAt(j) - 'a';
            ans += Math.min(Math.abs(chj - chi), 26 - Math.abs(chj - chi));
            i++;
            j--;
        }
        return ans;
    }
}
