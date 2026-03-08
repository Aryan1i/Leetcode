//Problem

    /*You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:
    
    Type-1: Remove the character at the start of the string s and append it to the end of the string.
    Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
    Return the minimum number of type-2 operations you need to perform such that s becomes alternating.
    
    The string is called alternating if no two adjacent characters are equal.
    
    For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
     
    
    Example 1:
    
    Input: s = "111000"
    Output: 2
    Explanation: Use the first operation two times to make s = "100011".
    Then, use the second operation on the third and sixth elements to make s = "101010".
    Example 2:
    
    Input: s = "010"
    Output: 0
    Explanation: The string is already alternating.
    Example 3:
    
    Input: s = "1110"
    Output: 1
    Explanation: Use the second operation on the second element to make s = "1010".
     
    
    Constraints:
    
    1 <= s.length <= 105
    s[i] is either '0' or '1'.*/

//Solution

class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int res = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < str.length(); right++) {

            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';

            if (str.charAt(right) != expected1) diff1++;
            if (str.charAt(right) != expected2) diff2++;

            if (right - left + 1 > n) {
                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if (str.charAt(left) != leftExpected1) diff1--;
                if (str.charAt(left) != leftExpected2) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}
