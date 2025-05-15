/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serial;
    public void Convert_to_String(TreeNode root){
        if(root == null){
            serial += "# ";
            return;
        }
        serial += root.val + " ";
        Convert_to_String(root.left);
        Convert_to_String(root.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      //Preoder 
      serial = "";
      Convert_to_String(root);
      return serial;  
    }
    // Decodes your encoded data to tree.
    public int idx = -1;
    public TreeNode deserialize(String data) {
        //convert to tree
        String node[] = data.split(" ");
        return Buildtree(node);
    }
    public TreeNode Buildtree(String node[]){
        idx++;
        if(node[idx].equals("#")){
         return null;
        }
        TreeNode newnode = new TreeNode(Integer.parseInt(node[idx]));
        newnode.left = Buildtree(node);
        newnode.right = Buildtree(node);
        return newnode;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));