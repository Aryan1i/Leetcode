//Problem
    
    /*You are given a string password.
    
    The strength of the password is calculated based on the following rules:
    
    1 point for each distinct lowercase letter ('a' to 'z').
    2 points for each distinct uppercase letter ('A' to 'Z').
    3 points for each distinct digit ('0' to '9').
    5 points for each distinct special character from the set "!@#$".
    Each character contributes at most once, even if it appears multiple times.
    
    Return an integer denoting the strength of the password.
    
     
    
    Example 1:
    
    Input: password = "aA1!"
    
    Output: 11
    
    Explanation:
     
    The distinct characters are 'a', 'A', '1' and '!'.
    Thus, the strength = 1 + 2 + 3 + 5 = 11.
    Example 2:
    
    Input: password = "bbB11#"
    
    Output: 11
    
    Explanation:
    
    The distinct characters are 'b', 'B', '1' and '#'.
    Thus, the strength = 1 + 2 + 3 + 5 = 11.​​​​​​​
     
    
    Constraints:
    
    1 <= password.length <= 105
    password consists of lowercase and uppercase English letters, digits, and special characters from "!@#$".*/

//Solution

class Solution {
    public int passwordStrength(String password) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        boolean[] digit = new boolean[10];
        boolean[] special = new boolean[4];

        int strength = 0;

        for (char ch : password.toCharArray()) {

            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                if (!lower[idx]) {
                    lower[idx] = true;
                    strength += 1;
                }
            } else if (ch >= 'A' && ch <= 'Z') {
                int idx = ch - 'A';
                if (!upper[idx]) {
                    upper[idx] = true;
                    strength += 2;
                }
            } else if (ch >= '0' && ch <= '9') {
                int idx = ch - '0';
                if (!digit[idx]) {
                    digit[idx] = true;
                    strength += 3;
                }
            } else {
                int idx = 0;

                if (ch == '!') idx = 0;
                else if (ch == '@') idx = 1;
                else if (ch == '#') idx = 2;
                else idx = 3;

                if (!special[idx]) {
                    special[idx] = true;
                    strength += 5;
                }
            }
        }

        return strength;
    }
}
