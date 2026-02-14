//Problem

    /*Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
    
    You can return the answer in any order.
    
     
    
    Example 1:
    
    
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
    Output: [7,4,1]
    Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
    Example 2:
    
    Input: root = [1], target = 1, k = 3
    Output: []
     
    
    Constraints:
    
    The number of nodes in the tree is in the range [1, 500].
    0 <= Node.val <= 500
    All the values Node.val are unique.
    target is the value of one of the nodes in the tree.
    0 <= k <= 1000*/

//Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();

        List<TreeNode> ntr = NodeToRoot(root,target.val);
        for(int i=0;i<ntr.size();i++){
            List<Integer> temp = klevelDown(ntr.get(i),k-i,i==0?null:ntr.get(i-1));
            list.addAll(temp);
        }   
        return list;
    }

    public static List<TreeNode> NodeToRoot(TreeNode root,int target){
        if(root == null) return new ArrayList<>();
        if(root.val == target){
            ArrayList<TreeNode> temp = new ArrayList<>();
            temp.add(root);
            return temp;
        }

        if(root.left != null){
            List<TreeNode> llist = NodeToRoot(root.left,target);
            if(llist.size()>0){
                llist.add(root);
                return llist;
            }
        }
        
        if(root.right != null){
            List<TreeNode> rlist = NodeToRoot(root.right,target);
            if(rlist.size()>0){
                rlist.add(root);
                return rlist;
            }
        }
        return new ArrayList<>();
    }

    public static List<Integer> klevelDown(TreeNode root,int k,TreeNode blocker){
        if(root== null)return new ArrayList<>();
        Queue < TreeNode > que = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        que.add(root);
        int level=0;
        while(que.size()>0){
            int size = que.size();
            if(level == k){
                for(int i=0;i<size;i++){
                    TreeNode top = que.remove();
                    list.add(top.val);
                }
                return list;
            }

            for(int i=0;i<size;i++){
                TreeNode top = que.remove();
                if(top.left != null && top.left != blocker) que.add(top.left);
                if(top.right != null&& top.right != blocker) que.add(top.right);
            }
            level++;
        }
        return new ArrayList<>();
    }
}
