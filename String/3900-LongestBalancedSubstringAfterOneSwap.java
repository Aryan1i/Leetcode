//Problem
    
    /*You are given a binary string s consisting only of characters '0' and '1'.
    
    A string is balanced if it contains an equal number of '0's and '1's.
    
    You can perform at most one swap between any two characters in s. Then, you select a balanced substring from s.
    
    Return an integer representing the maximum length of the balanced substring you can select.
    
     
    
    Example 1:
    
    Input: s = "100001"
    
    Output: 4
    
    Explanation:
    
    Swap "100001". The string becomes "101000".
    Select the substring "101000", which is balanced because it has two '0's and two '1's.
    Example 2:
    
    Input: s = "111"
    
    Output: 0
    
    Explanation:
    
    Choose not to perform any swaps.
    Select the empty substring, which is balanced because it has zero '0's and zero '1's.
     
    
    Constraints:
    
    1 <= s.length <= 105
    s consists only of the characters '0' and '1'.*/

//Solution

import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        
        int n = s.length();

        int totalOnes = 0, totalZeros = 0;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') totalOnes++;
            else totalZeros++;
        }
        
        int prefixOnes = 0, prefixZeros = 0;
        Map<Integer, List<Integer>> diffIndices = new HashMap<>();
        
        diffIndices.put(0, new ArrayList<>());
        diffIndices.get(0).add(0);
        
        int maxLen = 0;

        for(int i = 1; i <= n; i++){
            if(s.charAt(i - 1) == '1') prefixOnes++;
            else prefixZeros++;

            int diff = prefixOnes - prefixZeros;

            if(diff == 0) maxLen = Math.max(maxLen, i);

            if(diffIndices.containsKey(diff)){
                maxLen = Math.max(maxLen, i - diffIndices.get(diff).get(0)); 
            }

            if(diff < 0 && diffIndices.containsKey(diff + 2)){
                for(int startIdx : diffIndices.get(diff + 2)){
                    int requiredZeros = (i - startIdx) / 2;
                    if(totalOnes >= requiredZeros){
                        maxLen = Math.max(maxLen, i - startIdx);
                    }
                }
            }
            else if(diff > 0 && diffIndices.containsKey(diff - 2)){
                for(int startIdx : diffIndices.get(diff - 2)){ 
                    int requiredOnes = (i - startIdx) / 2;
                    if(totalZeros >= requiredOnes){
                        maxLen = Math.max(maxLen, i - startIdx);
                    }
                }
            }

            diffIndices.putIfAbsent(diff, new ArrayList<>());
            if(diffIndices.get(diff).size() <= 1){
                diffIndices.get(diff).add(i);
            }
        }
        return maxLen;
    }
}
