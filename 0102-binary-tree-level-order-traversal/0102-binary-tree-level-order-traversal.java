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
    public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;  // Edge case
    //creating queue linkedlist
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    //traversal level by level with queue
    while(!q.isEmpty()){
        int size = q.size();
        //level keeps checks of elements in respective level
        List<Integer> level = new ArrayList<>();
        for(int i=0;i<size;i++){
            //node linkedlist takes queue value
            TreeNode node = q.poll();
            //then adds it to level list
            level.add(node.val);
            //checks left and right nodes
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        //adds to ans ArrayList
        ans.add(level);
    }
    return ans;
}
}