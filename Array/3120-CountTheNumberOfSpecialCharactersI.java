//Problem
    
    /*You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
    
    Return the number of special letters in word.
    
     
    
    Example 1:
    
    Input: word = "aaAbcBC"
    
    Output: 3
    
    Explanation:
    
    The special characters in word are 'a', 'b', and 'c'.
    
    Example 2:
    
    Input: word = "abc"
    
    Output: 0
    
    Explanation:
    
    No character in word appears in uppercase.
    
    Example 3:
    
    Input: word = "abBCab"
    
    Output: 1
    
    Explanation:
    
    The only special character in word is 'b'.
    
     
    
    Constraints:
    
    1 <= word.length <= 50
    word consists of only lowercase and uppercase English letters.*/

//Solution

class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] b = new boolean[26];

        HashSet<Character> set = new HashSet<>();

        int ans = 0;
        for(char ch : word.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                if(!b[ch - 'A'] && set.contains((char)(ch + 32))) {
                    ans++;
                    b[ch - 'A'] = true;
                }
            } else {
                if(!b[ch - 'a'] && set.contains((char)(ch - 32))) {
                    ans++;
                    b[ch - 'a'] = true;
                }
            }
            set.add(ch);
        }

        return ans;
    }
}
