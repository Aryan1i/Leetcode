//Problem
    
    /*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
    
     
    
    Example 1:
    
    
    Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    Output: [3,9,20,null,null,15,7]
    Example 2:
    
    Input: inorder = [-1], postorder = [-1]
    Output: [-1]
     
    
    Constraints:
    
    1 <= inorder.length <= 3000
    postorder.length == inorder.length
    -3000 <= inorder[i], postorder[i] <= 3000
    inorder and postorder consist of unique values.
    Each value of postorder also appears in inorder.
    inorder is guaranteed to be the inorder traversal of the tree.
    postorder is guaranteed to be the postorder traversal of the tree.
     
    
    Seen this question in a real interview before?
    1/6
    Yes
    No
    Accepted
    1,021,855/1.5M
    Acceptance Rate
    69.6%
    */

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return solve(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode solve(int[] inorder, int[] postorder, int ps, int pe, int is, int ie){
        
        if(ps > pe) return null;

        int rootData = postorder[pe];
        TreeNode root = new TreeNode(rootData);

        int i = is;
        for( ; i <= ie; i++){
            if(inorder[i] == rootData) break;
        }

        int le = i - is;
        int re = ie - i;

        root.left = solve(inorder, postorder, pe - re - le, pe - re - 1, is, i - 1);
        root.right = solve(inorder, postorder, pe - re, pe - 1, i + 1, ie);

        return root;
    }
}
