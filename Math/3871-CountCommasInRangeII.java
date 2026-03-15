//Problem
    
    /*You are given an integer n.
    
    Return the total number of commas used when writing all integers from [1, n] (inclusive) in standard number formatting.
    
    In standard formatting:
    
    A comma is inserted after every three digits from the right.
    Numbers with fewer than 4 digits contain no commas.
     
    
    Example 1:
    
    Input: n = 1002
    
    Output: 3
    
    Explanation:
    
    The numbers "1,000", "1,001", and "1,002" each contain one comma, giving a total of 3.
    
    Example 2:
    
    Input: n = 998
    
    Output: 0
    
    Explanation:
    
    ​​​​​​​All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.
    
     
    
    Constraints:
    
    1 <= n <= 1015*/

//Solution

class Solution {
    public long countCommas(long n) {
        long count = 0;
        long a = (long)Math.pow(10,15);
        long b = (long)Math.pow(10,12);
        long c = 1000000000;
        long d = 1000000;
        long e = 1000;
        while(n > 999){
            if(n >= a){
                count += ((n - a) + 1 ) * 5;
                n -= (n - a) + 1;
            } else if (n >= b){
                count += ((n - b) + 1 ) * 4;
                n -= (n - b) + 1;
            } else if (n >= c){
                count += ((n - c) + 1 ) * 3;
                n -= (n - c) + 1;
            }else if(n >= d){
                 count += ((n - d) + 1 ) * 2;
                n -= (n-d) +1;
            } else if (n >= e){
                count += ((n - e) + 1);
                n-= (n-e) + 1;
            }
        }
        return count;
    }
}
