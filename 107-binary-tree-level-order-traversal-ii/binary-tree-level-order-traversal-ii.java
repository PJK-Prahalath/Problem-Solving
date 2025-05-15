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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int levelS = q.size();
            List<Integer> level = new ArrayList<>();

            // Process all nodes at the current level
            for(int i = 0; i < levelS; i++){
                TreeNode currN = q.poll();  // Dequeue the front node
                level.add(currN.val);   // Add its value to the current level list

                if(currN.left != null) q.add(currN.left);
                if(currN.right != null) q.add(currN.right);
            }
            // Add the current level to the beginning of the result list
            // Using LinkedList allows us to efficiently add to the front
            res.add(0, level);
        }
        return res;
    }
}