//Problem
    
    /*Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
    
    A shift on s consists of moving the leftmost character of s to the rightmost position.
    
    For example, if s = "abcde", then it will be "bcdea" after one shift.
     
    
    Example 1:
    
    Input: s = "abcde", goal = "cdeab"
    Output: true
    Example 2:
    
    Input: s = "abcde", goal = "abced"
    Output: false
     
    
    Constraints:
    
    1 <= s.length, goal.length <= 100
    s and goal consist of lowercase English letters.*/

//Solution

class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int length = s.length();
        char[] sChars = s.toCharArray();

        for (int rotationCount = 0; rotationCount < length; ++rotationCount) {
            sChars = rotate(sChars);
            if (new String(sChars).equals(goal)) return true;
        }
        return false;
    }

    private char[] rotate(char[] arr) {
        char firstChar = arr[0];
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        arr[arr.length - 1] = firstChar;
        return arr;
    }
}
