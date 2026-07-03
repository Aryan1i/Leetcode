//Problem
    
    /*You are given an m x n binary matrix grid and an integer health.
    
    You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).
    
    You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.
    
    Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.
    
    Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.
    
     
    
    Example 1:
    
    Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1
    
    Output: true
    
    Explanation:
    
    The final cell can be reached safely by walking along the gray cells below.
    
    
    Example 2:
    
    Input: grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3
    
    Output: false
    
    Explanation:
    
    A minimum of 4 health points is needed to reach the final cell safely.
    
    
    Example 3:
    
    Input: grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5
    
    Output: true
    
    Explanation:
    
    The final cell can be reached safely by walking along the gray cells below.
    
    
    
    Any path that does not go through the cell (1, 1) is unsafe since your health will drop to 0 when reaching the final cell.
    
     
    
    Constraints:
    
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    2 <= m * n
    1 <= health <= m + n
    grid[i][j] is either 0 or 1.*/

//Solution

class Solution {

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        int shealth = health - grid.get(0).get(0);

        for(int i = 0; i < m; i++){
            Arrays.fill(best[i], -1);
        }

        q.offer(new int[]{0, 0, shealth});

        int[][] dir = {{1, 0} , {-1 , 0} , {0 , 1}, {0, -1}};

        while(q.size() > 0){
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int h = curr[2];
            
            if (r == m - 1 && c == n - 1) return true;

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int newHealth = h - grid.get(nr).get(nc);

                if (newHealth <= 0)
                    continue;

                if (newHealth <= best[nr][nc])
                    continue;

                best[nr][nc] = newHealth;

                q.offer(new int[]{nr, nc, newHealth});
            }
        }

        return false;
    }
}
