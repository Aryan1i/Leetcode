//Problem

    /*Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
    
    You can use each character in text at most once. Return the maximum number of instances that can be formed.
    
     
    
    Example 1:
    
    
    
    Input: text = "nlaebolko"
    Output: 1
    Example 2:
    
    
    
    Input: text = "loonbalxballpoon"
    Output: 2
    Example 3:
    
    Input: text = "leetcode"
    Output: 0
     
    
    Constraints:
    
    1 <= text.length <= 104
    text consists of lower case English letters only.
     
    
    Note: This question is the same as 2287: Rearrange Characters to Make Target String.*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] fre = new int[26];

        for(char ch : text.toCharArray()){
            fre[ch - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++){
            if((char)(i + 'a') == 'l' || (char)(i + 'a') == 'o') {
                ans = Math.min(fre[i] / 2, ans);
                continue;
            }
            if(i != 0 && i != 1 && (char)(i + 'a') != 'n') continue;
            ans = Math.min(fre[i], ans);
        }

        return ans;
    }
}
