//Problem
    
    /*Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
    
    For example:
    
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
     
    
    Example 1:
    
    Input: columnTitle = "A"
    Output: 1
    Example 2:
    
    Input: columnTitle = "AB"
    Output: 28
    Example 3:
    
    Input: columnTitle = "ZY"
    Output: 701
     
    
    Constraints:
    
    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].*/

//Solution

class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;

        for(int i = 0; i < n; i++){
            char ch = columnTitle.charAt(n - (i + 1));
            ans += (ch - 64) * Math.pow(26, i);
        }

        return ans;
    }
}
