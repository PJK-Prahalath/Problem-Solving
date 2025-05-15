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
        List<List<Integer>>a=new ArrayList<>();
        levelorder(root,a);
        return a;
    }
    public static void levelorder(TreeNode root,List<List<Integer>>a){
        if(root==null){
            return;
        }
        List<Integer>b=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            
            if (currNode == null) {
                a.add(new ArrayList<>(b));  // Add copy of current level to result
                b.clear();                  // Clear current level list
                if (!q.isEmpty()) {         // Only add null if queue isn't empty
                    q.add(null);
                }
            } else {
                b.add(currNode.val);        // Add value to current level list
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
}