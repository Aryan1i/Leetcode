    //Problem
    
    /*You are given two integer arrays start and target, where each array is of the form [x, y] representing a cell on a standard 8 x 8 chessboard.
    
    Return true if a knight can move from start to target in an even number of moves. Otherwise, return false.
    
    Note: A valid knight move consists of moving two squares in one direction and one square perpendicular to it. The figure below illustrates all eight possible moves from a cell.
    
    
    
     
    
    Example 1:
    
    Input: start = [1,1], target = [2,2]
    
    Output: true
    
    Explanation:
    
    One possible sequence of moves is (1, 1) -> (3, 2) -> (2, 4) -> (4, 3) -> (2, 2).
    
    The knight reaches the target in 4 moves, which is even. Thus, the answer is true.
    
    Example 2:
    
    Input: start = [4,5], target = [6,6]
    
    Output: false
    
    Explanation:​​​​​​​
    
    It is impossible to reach target = [6, 6] from start = [4, 5] in an even number of moves. Thus, the answer is false.
    
     
    
    Constraints:
    
    start.length == target.length == 2
    0 <= start[i], target[i] <= 7*/

//Solution

class Solution {
    public boolean canReach(int[] start, int[] target) {
        return rec(start, target, 0);
    }

    boolean[][] visi = new boolean[8][8];
    
    public boolean rec(int[] sta , int[] tar, int st){
        if(sta[0] < 0 || sta[0] > 7 || sta[1] < 0 || sta[1] > 7) return false;
        if(visi[sta[0]][sta[1]]) return false;
        visi[sta[0]][sta[1]] = true;
        if(sta[0] == tar[0] && sta[1] == tar[1] && st % 2 == 0) return true;;

        if(rec(new int[]{sta[0] - 2, sta[1] - 1}, tar, st + 1)) return true;
        if(rec(new int[]{sta[0] - 2, sta[1] + 1}, tar, st + 1)) return true;;
        if(rec(new int[]{sta[0] - 1, sta[1] + 2}, tar, st + 1)) return true;;
        if(rec(new int[]{sta[0] + 1, sta[1] + 2}, tar, st + 1))return true;;
        if(rec(new int[]{sta[0] + 2, sta[1] + 1}, tar, st + 1))return true;;
        if(rec(new int[]{sta[0] + 2, sta[1] - 1}, tar, st + 1))return true;;
        if(rec(new int[]{sta[0] - 1, sta[1] - 2}, tar, st + 1))return true;;
        if(rec(new int[]{sta[0] + 1, sta[1] - 2}, tar, st + 1))return true;;

        return false;
    }
}
