//Problem
    
    /*You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
    
    We repeatedly make k duplicate removals on s until we no longer can.
    
    Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
    
     
    
    Example 1:
    
    Input: s = "abcd", k = 2
    Output: "abcd"
    Explanation: There's nothing to delete.
    Example 2:
    
    Input: s = "deeedbbcccbdaa", k = 3
    Output: "aa"
    Explanation: 
    First delete "eee" and "ccc", get "ddbbbdaa"
    Then delete "bbb", get "dddaa"
    Finally delete "ddd", get "aa"
    Example 3:
    
    Input: s = "pbbcggttciiippooaais", k = 2
    Output: "ps"
     
    
    Constraints:
    
    1 <= s.length <= 105
    2 <= k <= 104
    s only contains lowercase English letters.*/

//Solution

class Solution {
    class Pair{
        char ch;
        int fre;

        Pair(char ch, int fre){
            this.ch = ch;
            this.fre = fre;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(st.isEmpty() || st.peek().ch != ch){
                st.push(new Pair(ch, 1));
            } else {
                Pair top = st.pop();
                st.push(new Pair(top.ch, top.fre + 1));
                if(st.peek().fre == k){
                    st.pop();
                }
            }
        }

        String ans = "";

        for(Pair p : st){
            for(int i = 0; i < p.fre; i++){
                ans += p.ch;
            }
        }

        return ans;
    }
}
