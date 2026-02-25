//Problem
    
    /*You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
    
    Return the number of complete connected components of the graph.
    
    A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
    
    A connected component is said to be complete if there exists an edge between every pair of its vertices.
    
     
    
    Example 1:
    
    
    
    Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
    Output: 3
    Explanation: From the picture above, one can see that all of the components of this graph are complete.
    Example 2:
    
    
    
    Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
    Output: 1
    Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
     
    
    Constraints:
    
    1 <= n <= 50
    0 <= edges.length <= n * (n - 1) / 2
    edges[i].length == 2
    0 <= ai, bi <= n - 1
    ai != bi
    There are no repeated edges.*/

//Solution

class Solution {
    public static class Edge{
        int v1;
        int v2;

        Edge(int v1,int v2){
            this.v1 = v1;
            this.v2 = v2;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }

        ArrayList<ArrayList<Integer>>  list = getConnectedComponents (graph , n);

        int count = 0;
        for(ArrayList<Integer> temp : list){
            boolean  x = cheak(graph,temp);
            if(x == true) count++;
        }
        return count;
    }

    public static boolean cheak(ArrayList<Edge>[] graph, ArrayList<Integer> list){
        int n = list.size();
        int sum = 0;
        for(int i : list){
            sum += graph[i].size();
        }

        if(sum == n*(n-1)){
            return true;
        } else {
            return false;
        }
    }


    public ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph, int n){

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(visited[i] == true) continue;
            ArrayList<Integer> comp = new ArrayList<>();
            dfs(graph , visited, i, comp);
            list.add(comp);
        }

        return list;
    }

    public static void dfs(ArrayList<Edge>[] graph,boolean[] visited,int source,ArrayList<Integer> list){
        list.add(source);
        visited[source] = true;
        for(Edge edge : graph[source]){
            if(visited[edge.v2] != true){
               dfs(graph,visited,edge.v2, list);
            }
        }
    }
}
