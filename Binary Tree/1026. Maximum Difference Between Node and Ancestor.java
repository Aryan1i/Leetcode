//Problem
    
    /*Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
    
    A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
    
     
    
    Example 1:
    
    
    Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
    Output: 7
    Explanation: We have various ancestor-node differences, some of which are given below :
    |8 - 3| = 5
    |3 - 7| = 4
    |8 - 1| = 7
    |10 - 13| = 3
    Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
    Example 2:
    
    
    Input: root = [1,null,2,null,0,3]
    Output: 3
     
    
    Constraints:
    
    The number of nodes in the tree is in the range [2, 5000].
    0 <= Node.val <= 105*/

//Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return solve(root)[0];
    }

    public int[] solve(TreeNode root){
        if(root == null) return new int[]{-1, 0, 0};
        if(root.left == null && root.right == null) return new int[]{0, root.val, root.val};

        int[] l = solve(root.left);
        int[] r = solve(root.right);

        int[] ansl = new int[3];
        if(l[0] != -1){
            int mind = Math.abs(l[1] - root.val);
            int maxd = Math.abs(l[2] - root.val);

            if(Math.max(mind, maxd) > l[0]){
                ansl[0] =  Math.max(mind, maxd);
            } else {
                ansl[0] = l[0];
            }

            if(l[1] > root.val) ansl[1] = l[1];
            else ansl[1] = root.val;

            if(l[2] < root.val) ansl[2] = l[2];
            else ansl[2] = root.val;
        }

        int[] ansr = new int[3];
        if(r[0] != -1){
            int mind = Math.abs(r[1] - root.val);
            int maxd = Math.abs(r[2] - root.val);

            if(Math.max(mind, maxd) > r[0]){
                ansr[0] =  Math.max(mind, maxd);
            } else {
                ansr[0] = r[0];
            }

            if(r[1] > root.val) ansr[1] = r[1];
            else ansr[1] = root.val;

            if(r[2] < root.val) ansr[2] = r[2];
            else ansr[2] = root.val;
        }

        int maxDiff = Math.max(ansl[0], ansr[0]);

        int maxVal = root.val;
        int minVal = root.val;

        if(l[0] != -1) {
            maxVal = Math.max(maxVal, ansl[1]);
            minVal = Math.min(minVal, ansl[2]);
        }

        if(r[0] != -1) {
            maxVal = Math.max(maxVal, ansr[1]);
            minVal = Math.min(minVal, ansr[2]);
        }

        return new int[]{maxDiff, maxVal, minVal};
    }
}
