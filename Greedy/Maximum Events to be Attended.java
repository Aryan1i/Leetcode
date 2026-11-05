//Problem
    
    /*Given n events represented by the arrays start[] and end[], where the i-th event starts on start[i] and ends on end[i]. Each event can be attended on any single day within the range [start[i], end[i]], and at most one event can be attended per day.
    
    Find the maximum number of events that can be attended.
    
    Examples :
    
    Input: start[] = [1, 2, 1], end[] = [1, 2, 2]
    Output: 2
    Explanation: One possible way to attend the maximum 2 events is:
    Attend the 1st event on Day 1 and 2nd event on Day 2.
    Input: start[] = [1, 2, 3], end[] = [2, 3, 4] 
    Output : 3
    Explanation: One possible way to attend all the 3 events is:
    Attend the 1st event on Day 1, the 2nd event on Day 2, and the 3rd event on Day 3.
    Constraints:
    
    1 ≤ start.size() ≤ 105
    1 ≤ start[i], end[i] ≤ 2*105
    end.size() = start.size()
    start[i] ≤ end[i]*/

//Solution

class Solution {
    public int maxEvents(List<Integer> start, List<Integer> end) {

        int n = start.size();

        int[][] events = new int[n][2];

        for(int i = 0; i < n; i++){
            events[i][0] = start.get(i);
            events[i][1] = end.get(i);
        }

        Arrays.sort(events, (a, b) -> 
            Integer.compare(a[0], b[0])
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int day = 1;
        int i = 0;
        int ans = 0;

        while(i < n || !pq.isEmpty()){

            while(i < n && events[i][0] <= day){
                pq.offer(events[i][1]);
                i++;
            }

            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                ans++;
                day++;
            }
            else if(i < n){
                day = events[i][0];
            }
        }

        return ans;
    }
}
