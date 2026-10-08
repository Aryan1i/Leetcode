//Problem
    
    /*Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
    
    Assume a BST is defined as follows:
    
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
     
    
    Example 1:
    
    
    
    Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
    Output: 20
    Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
    Example 2:
    
    
    
    Input: root = [4,3,null,1,2]
    Output: 2
    Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
    Example 3:
    
    Input: root = [-4,-2,-5]
    Output: 0
    Explanation: All values are negatives. Return an empty BST.
     
    
    Constraints:
    
    The number of nodes in the tree is in the range [1, 4 * 104].
    -4 * 104 <= Node.val <= 4 * 104*/

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
    int ans = 0;
    public int maxSumBST(TreeNode root) {
         solve(root);
         return ans;
    }

    public int[] solve(TreeNode root){
        if(root == null) return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] l = solve(root.left);
        int[] r = solve(root.right);

        if (l[0] == 1 && r[0] == 1 && root.val > l[3] && root.val < r[2]) {
            int currentSum = l[1] + r[1] + root.val;
            ans = Math.max(ans, currentSum);
            
            int minVal = Math.min(root.val, l[2]);
            int maxVal = Math.max(root.val, r[3]);
            
            return new int[]{1, currentSum, minVal, maxVal};
        } else {
            return new int[]{0, 0, 0, 0};
        }
    }
}
