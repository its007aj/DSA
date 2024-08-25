/*
https://leetcode.com/problems/binary-tree-postorder-traversal/?envType=daily-question&envId=2024-08-25
*/


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
    List<Integer> postOrder;

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder = new ArrayList<>();
        post(root);
        return postOrder;
    }

    public void post(TreeNode root){
        if(root==null)
            return;

        post(root.left);
        post(root.right);
        postOrder.add(root.val);
    }
}
