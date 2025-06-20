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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, String.valueOf(root.val)));

        while (!stack.isEmpty()){
            Pair <TreeNode, String> node = stack.pop();

            TreeNode pointer = node.getKey();
            String path = node.getValue();

            if (pointer.left == null && pointer.right == null)
                ans.add(path);

            if (pointer.left != null)
                stack.push(new Pair<>(pointer.left, path + "->" + pointer.left.val));
            if (pointer.right != null)
                stack.push(new Pair<>(pointer.right, path + "->" + pointer.right.val));
        }
        return ans;
    }
}