//Problem
    
    /*You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.
    
    The score of a path between two cities is defined as the minimum distance of a road in this path.
    
    Return the minimum possible score of a path between cities 1 and n.
    
    Note:
    
    A path is a sequence of roads between two cities.
    It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
    The test cases are generated such that there is at least one path between 1 and n.
     
    
    Example 1:
    
    
    Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
    Output: 5
    Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
    It can be shown that no other path has less score.
    Example 2:
    
    
    Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
    Output: 2
    Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
     
    
    Constraints:
    
    2 <= n <= 105
    1 <= roads.length <= 105
    roads[i].length == 3
    1 <= ai, bi <= n
    ai != bi
    1 <= distancei <= 104
    There are no repeated edges.
    There is at least one path between 1 and n.*/

//Solution

class Solution {

    boolean[] visited;
    
    public int minScore(int n, int[][] roads) {
        visited = new boolean[n + 1];
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        return helper(graph, 1, Integer.MAX_VALUE);
    }

    public int helper(ArrayList<ArrayList<int[]>> graph,int n, int min){
        visited[n] = true;

        for(int[] g : graph.get(n)){
            min = Math.min(min, g[1]);

            if (!visited[g[0]]) {
                min = Math.min(min, helper(graph, g[0], min));
            }
        }

        return min;
    }
}
