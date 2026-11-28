//Problem
    
    /*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    
    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    
    
     
    
    Example 1:
    
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    Example 2:
    
    Input: digits = "2"
    Output: ["a","b","c"]
     
    
    Constraints:
    
    1 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].*/

//Solution

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        solve(0, "", digits, ans);
        return ans;
    }

    public void solve(int i, String s, String digits, List<String> ans){
        if(i == digits.length()){
            ans.add(s);
            return;
        }

        int d = digits.charAt(i) - '0';
        int x = ((d - 2) * 3) + 97;
        if(d < 8){
            solve(i + 1, s + (char)x, digits, ans);
            solve(i + 1, s + (char)(x + 1), digits, ans);
            solve(i + 1, s + (char)(x + 2), digits, ans);
        } else {
            solve(i + 1, s + (char)(x + 1), digits, ans);
            solve(i + 1, s + (char)(x + 2), digits, ans);
            solve(i + 1, s + (char)(x + 3), digits, ans);
        } 
        
        if(d == 7) solve(i + 1, s + (char)(x + 3), digits, ans);
        if(d == 9) solve(i + 1, s + (char)(x + 4), digits, ans);
    }
}
