//Problem
    
    /*Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
    
     
    
    Example 1:
    
    
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[20,9],[15,7]]
    Example 2:
    
    Input: root = [1]
    Output: [[1]]
    Example 3:
    
    Input: root = []
    Output: []
     
    
    Constraints:
    
    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100*/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null) return new ArrayList<>();

        dq.push(root);
        int l = 1;

        List<List<Integer>> ans = new ArrayList<>();
        while(dq.size() > 0){
            l++;
            int size = dq.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                if(l % 2 == 0){
                    TreeNode curr = dq.removeLast();
                    temp.add(curr.val);
                    if(curr.left != null) dq.addFirst(curr.left);
                    if(curr.right != null) dq.addFirst(curr.right);
                } else {
                    TreeNode curr = dq.removeFirst();
                    temp.add(curr.val);
                    if(curr.right != null) dq.addLast(curr.right);
                    if(curr.left != null) dq.addLast(curr.left);
                }
            }
            ans.add(temp);
        }

        return ans;
    }
}
