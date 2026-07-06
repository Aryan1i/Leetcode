//Problem
    
    /*You are given two strings s and t consisting of lowercase English letters.
    
    You may choose at most one index in s and replace the character at that index with any lowercase English letter.
    
    Return true if it is possible to make s a subsequence of t; otherwise, return false.
    
     
    
    Example 1:
    
    Input: s = "cat", t = "chat"
    
    Output: true
    
    Explanation:
    
    Replace s[1] from 'a' to 'h'. The resulting string is "cht".
    "cht" is a subsequence of "chat" because we can match 'c', 'h', and 't' in order.
    Example 2:
    
    Input: s = "plane", t = "apple"
    
    Output: false
    
    Explanation:
    
    The characters 'p', 'l', and 'e' can be matched in t, but the remaining characters cannot be matched while preserving the required order.
    Even after replacing any one character in s, it is impossible to make s a subsequence of t.
     
    
    Constraints:
    
    1 <= s.length, t.length <= 105
    s and t consist only of lowercase English letters.*/

//Solution

class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

          if(n>m) return false;
          
        int[] pre = new int[n];
        Arrays.fill(pre, m);
        int[] sff = new int[n];
        Arrays.fill(sff, -1);

        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < m && s.charAt(i) != t.charAt(j)) j++;
            if(j < m){
                pre[i] = j;
                j++;
            } else {
                break;
            }
        }

        j = m - 1;

        for(int i = n - 1; i >= 0; i--){
            while(j >= 0 && s.charAt(i) != t.charAt(j)) j--;

            if(j >= 0){
                sff[i] = j;
                j--;
            } else {
                break;
            }
        }

        for(int i = 0; i < n; i++){
            int a = i-1 < 0 ? -1: pre[i - 1];
            int b = i+1 >= n? m : sff[i+1];

            if(a != m && b != -1 && b - a >= 2) return true;
        }

        return false;
    }
}
