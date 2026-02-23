//Problem

    /*You are given a string s consisting only of the characters 'a', 'b', and 'c'.
    
    A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
    
    Return the length of the longest balanced substring of s.
    
     
    
    Example 1:
    
    Input: s = "abbac"
    
    Output: 4
    
    Explanation:
    
    The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.
    
    Example 2:
    
    Input: s = "aabcc"
    
    Output: 3
    
    Explanation:
    
    The longest balanced substring is "abc" because all distinct characters 'a', 'b' and 'c' each appear exactly 1 time.
    
    Example 3:
    
    Input: s = "aba"
    
    Output: 2
    
    Explanation:
    
    One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".
    
     
    
    Constraints:
    
    1 <= s.length <= 105
    s contains only the characters 'a', 'b', and 'c'.*/

//Solution

class Solution {
    public int longestBalanced(String s) {
        int a = 0;
        int b = 0;
        int c = 0;

        int oneMax = 0;
        int twoMax = 0;
        int threeMax = 0;

        char temp = '0';
        int max = 0;
       
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != temp){
                oneMax = Math.max(oneMax,max);
                temp = ch;
                max = 0;
            } 
            max++;
        }

        oneMax = Math.max(oneMax,max);
        maxLength = Math.max(maxLength,oneMax);

        twoMax = Math.max(twoMx(s,'a','b'),Math.max(twoMx(s,'b','c'),twoMx(s,'c','a')));
        maxLength = Math.max(maxLength,twoMax);

        int countA = 0;
        int countB = 0;
        int countC = 0;

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("0_0", -1);

        for(int i = 0;i<s.length();i++){
            char ch  = s.charAt(i);
            if(ch == 'a') countA++;
            if(ch == 'b') countB++;
            if(ch == 'c') countC++;

            if(countA == countB && countB == countC){
                maxLength = Math.max(maxLength,3*countA);
            }

            int diffAB = countA - countB;
            int diffAC = countA - countC;

            String key = Integer.toString(diffAB) + "_" + Integer.toString(diffAC);

            if(hm.containsKey(key)){
                maxLength = Math.max(maxLength,i-hm.get(key));
            } else {
                hm.put(key,i);
            }
        }

        return maxLength;
    }

    public static int twoMx(String s,char x,char y){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0, -1);

        int count1 = 0;
        int count2 = 0;

        int maxLength = 0;
        for(int i = 0; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == x){
                count1++;
            } else if(ch == y){
                count2++;
            } else {
                hm = new HashMap<>();
                hm.put(0, i);
                count1 = 0;
                count2 = 0;
                continue;
            }

            int diff = count1 - count2;

            if(hm.containsKey(diff) == true){
                maxLength = Math.max(maxLength,i - hm.get(diff));
            } else {
                hm.put(diff,i);
            }
        }

        return maxLength;
    }
}
