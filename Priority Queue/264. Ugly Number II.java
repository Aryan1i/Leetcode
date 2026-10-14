    //Problem
    
    /*An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
    
    Given an integer n, return the nth ugly number.
    
     
    
    Example 1:
    
    Input: n = 10
    Output: 12
    Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
    Example 2:
    
    Input: n = 1
    Output: 1
    Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
     
    
    Constraints:
    
    1 <= n <= 1690
     
    */

//Solution

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.offer(1L);
        set.add(1L);

        long i = 1;
        while(i != n){
            long x = pq.remove();

            if(set.add(x * 2L)){
                pq.add(x * 2L);
            }
            if(set.add(x * 3L)){
                pq.add(x * 3L);
            }
            if(set.add(x * 5L)){
                pq.add(x * 5L);
            }

            i++;
        }

        int ans = Math.toIntExact(pq.peek());
        return ans;
    }
}
