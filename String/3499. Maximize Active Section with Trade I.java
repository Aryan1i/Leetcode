    //Problem
    
    /*You are given a binary string s of length n, where:
    
    '1' represents an active section.
    '0' represents an inactive section.
    You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
    
    Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
    Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
    Return the maximum number of active sections in s after making the optimal trade.
    
    Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'. The augmented '1's do not contribute to the final count.
    
     
    
    Example 1:
    
    Input: s = "01"
    
    Output: 1
    
    Explanation:
    
    Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active sections is 1.
    
    Example 2:
    
    Input: s = "0100"
    
    Output: 4
    
    Explanation:
    
    String "0100" → Augmented to "101001".
    Choose "0100", convert "101001" → "100001" → "111111".
    The final string without augmentation is "1111". The maximum number of active sections is 4.
    Example 3:
    
    Input: s = "1000100"
    
    Output: 7
    
    Explanation:
    
    String "1000100" → Augmented to "110001001".
    Choose "000100", convert "110001001" → "110000001" → "111111111".
    The final string without augmentation is "1111111". The maximum number of active sections is 7.
    Example 4:
    
    Input: s = "01010"
    
    Output: 4
    
    Explanation:
    
    String "01010" → Augmented to "1010101".
    Choose "010", convert "1010101" → "1000101" → "1111101".
    The final string without augmentation is "11110". The maximum number of active sections is 4.
     
    
    Constraints:
    
    1 <= n == s.length <= 105
    s[i] is either '0' or '1'*/

//Solution

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int[] rz = new int[n];
        int[] lz = new int[n];
        int[] cor = new int[n];
        int[] col = new int[n];

        for(int i = 1; i < n; i++){
            if(s.charAt(i - 1) == '0'){
                lz[i] = lz[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i + 1) == '0'){
                rz[i] = rz[i + 1] + 1;
            }
        }

        if(s.charAt(0) == '1') col[0] = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '1'){
                col[i] = col[i - 1] + 1;
            } else {
                col[i] = col[i - 1] ;
            }
        }

        if(s.charAt(n - 1) == '1') cor[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '1'){
                cor[i] = cor[i + 1] + 1;
            } else {
                cor[i] = cor[i + 1];
            }
        }

        int i = 0;
        int j = 0;

        int ans = 0;
        while(j < n){
            if(s.charAt(i) == '0'){
                i++;
                j++;
            } else {
                while(j < n && s.charAt(j) == '1'){
                    j++;
                }
                j--;
                if(lz[i] != 0 && rz[j] != 0){
                    ans = Math.max(lz[i] + rz[j] + (j - i + 1) + ((i - (lz[i] + 1) >= 0) ?col[i - (lz[i] + 1)] : 0) + ((j + rz[j] + 1) < n ?cor[j + rz[j] + 1] : 0), ans);
                } else {
                    ans = Math.max(ans, (j - i) + 1 + ((i - (lz[i] + 1) >= 0) ?col[i - (lz[i] + 1)] : 0) + ((j + rz[j] + 1) < n ?cor[j + rz[j] + 1] : 0));
                }
                i = j + 1;
                j++; 
            }
        }

        return ans;
    }
}
