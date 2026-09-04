    //Problem
    
    /*You are given the root of a binary tree.
    
    Return the leftmost value in the last row of the tree.
    
     
    
    Example 1:
    
    
    Input: root = [2,1,3]
    Output: 1
    Explanation: The last row is [1,3], so the leftmost value is 1.
    Example 2:
    
    
    Input: root = [1,2,3,4,null,5,6,null,null,7]
    Output: 7
    Explanation: The last row contains only the node 7.
     
    
    Constraints:
    
    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1*/

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
    public int findBottomLeftValue(TreeNode root) {
        return solve(root, 0)[0];
    }

    public int[] solve(TreeNode root, int h){
        if(root == null) return new int[]{0, -1};
        if(root.left == null && root.right == null) return new int[]{root.val, h};

        int[] r = solve(root.right, h + 1);

        int[] l = solve(root.left, h + 1);

        if(l[1] >= r[1]){
            return l;
        } else {
            return r;
        }
    }
}
