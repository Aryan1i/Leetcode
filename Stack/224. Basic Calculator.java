    //Problem
    
    /*Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
    
    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
    
     
    
    Example 1:
    
    Input: s = "1 + 1"
    Output: 2
    Example 2:
    
    Input: s = " 2-1 + 2 "
    Output: 3
    Example 3:
    
    Input: s = "(1+(4+5+2)-3)+(6+8)"
    Output: 23
     
    
    Constraints:
    
    1 <= s.length <= 3 * 105
    s consists of digits, '+', '-', '(', ')', and ' '.
    s represents a valid expression.
    '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
    '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
    There will be no two consecutive operators in the input.
    Every number and running calculation will fit in a signed 32-bit integer.
     
    
    */

//Solution

class Solution {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }

                i--;
                st.push(sb.toString());
            }

            else if (ch == ')') {

                int open = st.size() - 1;

                while (!st.get(open).equals("(")) {
                    open--;
                }

                long result = Long.parseLong(st.get(open + 1));

                for (int j = open + 2; j < st.size(); j += 2) {
                    String operator = st.get(j);
                    long num = Long.parseLong(st.get(j + 1));

                    if (operator.equals("+")) {
                        result += num;
                    } else {
                        result -= num;
                    }
                }

                while (st.size() > open) {
                    st.pop();
                }

                st.push(String.valueOf(result));
            }

            else {
                if (ch == '-' &&
                    (st.isEmpty()
                    || st.peek().equals("(")
                    || st.peek().equals("+")
                    || st.peek().equals("-"))) {

                    st.push("0");
                }

                st.push(String.valueOf(ch));
            }
        }

        long result = Long.parseLong(st.get(0));

        for (int i = 1; i < st.size(); i += 2) {
            String operator = st.get(i);
            long num = Long.parseLong(st.get(i + 1));

            if (operator.equals("+")) {
                result += num;
            } else {
                result -= num;
            }
        }

        return (int) result;
    }
}
