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
    public void traversal(TreeNode root, List<List<Integer>> lt, int i) {
        if (root == null)
            return;
        if (i == lt.size())
            lt.add(new ArrayList<>());
        lt.get(i).add(root.val);
        traversal(root.left, lt, i + 1);
        traversal(root.right, lt, i + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lt = new ArrayList<>();
        traversal(root, lt, 0);
        for (int i = 1; i < lt.size(); i +=2) {
                Collections.reverse(lt.get(i));
        }
        return lt;
    }
}