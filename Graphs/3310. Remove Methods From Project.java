//Problem
    
    /*You are maintaining a project that has n methods numbered from 0 to n - 1.
    
    You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.
    
    There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.
    
    A group of methods can only be removed if no method outside the group invokes any methods within it.
    
    Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.
    
     
    
    Example 1:
    
    Input: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]
    
    Output: [0,1,2,3]
    
    Explanation:
    
    
    
    Method 2 and method 1 are suspicious, but they are directly invoked by methods 3 and 0, which are not suspicious. We return all elements without removing anything.
    
    Example 2:
    
    Input: n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]
    
    Output: [3,4]
    
    Explanation:
    
    
    
    Methods 0, 1, and 2 are suspicious and they are not directly invoked by any other method. We can remove them.
    
    Example 3:
    
    Input: n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]
    
    Output: []
    
    Explanation:
    
    
    
    All methods are suspicious. We can remove them.
    
     
    
    Constraints:
    
    1 <= n <= 105
    0 <= k <= n - 1
    0 <= invocations.length <= 2 * 105
    invocations[i] == [ai, bi]
    0 <= ai, bi <= n - 1
    ai != bi
    invocations[i] != invocations[j]*/

//Solution

class Solution {
    boolean[] visited;
    ArrayList<Integer> inDegree;
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        inDegree = new ArrayList<>();
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
            inDegree.add(0);
        }

        for(int i = 0; i < invocations.length ; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];

            graph.get(u).add(v);
            inDegree.set(v, inDegree.get(v) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        getSuspicious(graph, k);

        for(int i = 0; i < n; i++){
            if(visited[i] == true && inDegree.get(i) != 0){
                ans = new ArrayList<>();
                for(int j = 0; j < n; j++){
                    ans.add(j);
                }
                return ans;
            }
            if(visited[i] == false) ans.add(i);
        }

        return ans;
    }

    public void getSuspicious(ArrayList<ArrayList<Integer>> graph, int k){
        if(visited[k]) return;
        visited[k] = true;
        for(int node : graph.get(k)){
            inDegree.set(node, inDegree.get(node) - 1);
            getSuspicious(graph, node);
        }
    }
}
