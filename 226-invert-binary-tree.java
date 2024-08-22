/*
https://leetcode.com/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while(!q.isEmpty()){
            TreeNode head = q.removeLast();
            TreeNode right = null;
            TreeNode left = null;

            if(head.left!=null){
                q.addLast(head.left);
                left = head.left;
            }
                
            if(head.right!=null){
                q.addLast(head.right);
                right = head.right;
            }

            head.right = left;
            head.left = right;
        }
        
        return root;

    }
}
