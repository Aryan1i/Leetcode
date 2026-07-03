    //Problem
    
    /*Given a string s consisting only of characters a, b and c.
    
    Return the number of substrings containing at least one occurrence of all these characters a, b and c.
    
     
    
    Example 1:
    
    Input: s = "abcabc"
    Output: 10
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
    Example 2:
    
    Input: s = "aaacb"
    Output: 3
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
    Example 3:
    
    Input: s = "abc"
    Output: 1
     
    
    Constraints:
    
    3 <= s.length <= 5 x 10^4
    s only consists of a, b or c characters.*/

class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer>  map = new HashMap<>();
        int ans = 0;

        char i = 0;
        char j = 0;

        while(j < s.length() ){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.size() == 3){
                while(map.size() == 3){
                    ans += s.length() - j;

                    char chh = s.charAt(i);
                    map.put(chh, map.get(chh) - 1);
                    if(map.get(chh) == 0){
                        map.remove(chh);
                    }

                    i++;
                }
            }
            j++;
        }
        
        return ans;
    }
}
