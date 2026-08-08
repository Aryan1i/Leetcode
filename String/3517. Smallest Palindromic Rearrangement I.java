//Problem
    
    /*You are given a palindromic string s.
    
    Return the lexicographically smallest palindromic permutation of s.
    
     
    
    Example 1:
    
    Input: s = "z"
    
    Output: "z"
    
    Explanation:
    
    A string of only one character is already the lexicographically smallest palindrome.
    
    Example 2:
    
    Input: s = "babab"
    
    Output: "abbba"
    
    Explanation:
    
    Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.
    
    Example 3:
    
    Input: s = "daccad"
    
    Output: "acddca"
    
    Explanation:
    
    Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.
    
     
    
    Constraints:
    
    1 <= s.length <= 105
    s consists of lowercase English letters.
    s is guaranteed to be palindromic.*/

//Solution

class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                ans.append((char) ('a' + i));
            }

            if ((freq[i] & 1) == 1) {
                middle = (char) ('a' + i);
            }
        }

        int half = ans.length();

        if (middle != 0) {
            ans.append(middle);
        }

        for (int i = half - 1; i >= 0; i--) {
            ans.append(ans.charAt(i));
        }

        return ans.toString();
    }
}
