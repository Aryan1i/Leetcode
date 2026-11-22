    //Problem
    
    /*You are given three integers a, b, and c.
    
    You may perform the following operation any number of times (including zero):
    
    Choose one of the three integers and replace it with the sum of the other two integers. The other two integers remain unchanged.
    The range of three integers is defined as the difference between the maximum value and the minimum value.
    
    Return the minimum range that can be obtained after performing the operation any number of times.
    
     
    
    Example 1:
    
    Input: a = 9, b = 2, c = 5
    
    Output: 5
    
    Explanation:
    
    One sequence of operations which results in the minimum range is as follows:
    
    Set a to b + c = 2 + 5 = 7. The three integers are now a = 7, b = 2, c = 5.
    The range of the three integers is max(7, 2, 5) - min(7, 2, 5) = 7 - 2 = 5.
    Example 2:
    
    Input: a = 5, b = 7, c = 6
    
    Output: 2
    
    Explanation:
    
    Without doing any operations, the range of the three integers is max(5, 7, 6) - min(5, 7, 6) = 7 - 5 = 2.
    
    Example 3:
    
    Input: a = 3, b = 3, c = 3
    
    Output: 0
    
    Explanation:
    
    Without doing any operations, the range of the three integers is max(3, 3, 3) - min(3, 3, 3) = 3 - 3 = 0.
    
     
    
    Constraints:
    
    1 <= a, b, c <= 100*/

//Solution

class Solution {
    public int minRange(int a, int b, int c) {
       
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        
        Arrays.sort(arr);
        int ans = Math.min(arr[2] - arr[0], arr[1]);
        return ans;
    }
}
