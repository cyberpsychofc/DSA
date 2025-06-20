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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        Queue<TreeNode> q = new LinkedList<>() ;
        q.offer(root);

        while (!q.isEmpty()){
            int lvlSize = q.size();
            List<TreeNode> currLvl = new ArrayList<>();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);

                if (curr.left != null || curr.right != null){
                    TreeNode tmp = curr.left;
                    curr.left = curr.right;
                    curr.right = tmp;
                }
            }
        }
        return root;
    }
}