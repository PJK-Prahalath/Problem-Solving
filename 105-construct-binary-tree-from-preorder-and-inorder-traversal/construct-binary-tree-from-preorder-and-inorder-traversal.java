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
    int idx = 0;
    public TreeNode Build(int[] preorder, int start, int end,HashMap<Integer,Integer> map){
      if(start > end){
        return null;
      }

      int rootval = preorder[idx++];
      int pivotidx = map.get(rootval);
      TreeNode node = new TreeNode(rootval);
      node.left = Build(preorder,start,pivotidx - 1,map);
      node.right = Build(preorder, pivotidx + 1, end,map);
      return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      int m = inorder.length;
      HashMap<Integer, Integer> map = new HashMap<>();

      //store inorder
      for(int i=0; i<m; i++){
        map.put(inorder[i],i);
      }

      TreeNode root = Build(preorder,0,m-1,map);
      return root;
    }
}