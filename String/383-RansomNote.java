//Problem

    /*Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
    
    Each letter in magazine can only be used once in ransomNote.
    
     
    
    Example 1:
    
    Input: ransomNote = "a", magazine = "b"
    Output: false
    Example 2:
    
    Input: ransomNote = "aa", magazine = "ab"
    Output: false
    Example 3:
    
    Input: ransomNote = "aa", magazine = "aab"
    Output: true
     
    
    Constraints:
    
    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.*/

//Solution

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] fre = new int[26];

        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            fre[ch - 'a']++;
        }

        int[] fre2 = new int[26];

        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            fre2[ch - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(fre2[i] > fre[i]) return false;
        }

        return true;
    }
}
