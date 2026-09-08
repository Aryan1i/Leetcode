//Problem
    
    /*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
    
     
    
    Example 1:
    
    
    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    Output: [3,9,20,null,null,15,7]
    Example 2:
    
    Input: preorder = [-1], inorder = [-1]
    Output: [-1]
     
    
    Constraints:
    
    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.*/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return solve(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int preSt, int preEnd, int inSt, int inEnd){

        if(preSt > preEnd) return null;

        int head = preorder[preSt];
        int i = inSt;
        for( ; i <= inEnd; i++){
            if(inorder[i] == head) break;
        }

        int leftSize = i - inSt;

        TreeNode left = solve(preorder, inorder, preSt + 1, preSt + leftSize, inSt, i - 1);
        TreeNode right = solve(preorder, inorder, preSt + leftSize + 1, preEnd, i + 1, inEnd);

        return new TreeNode(head, left, right);
    }
}
