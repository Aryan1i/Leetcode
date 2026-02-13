//Problem

    /*Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
    
    A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
    
     
    
    Example 1:
    
    
    Input: root = [1,null,2,null,3,null,4,null,null]
    Output: [2,1,3,null,null,null,4]
    Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
    Example 2:
    
    
    Input: root = [2,1,3]
    Output: [2,1,3]
     
    
    Constraints:
    
    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 105*/

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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return buildBalancedBST(inorder, 0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    private TreeNode buildBalancedBST(List<Integer> list, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildBalancedBST(list, left, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, right);

        return node;
    }
}
