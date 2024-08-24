/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
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
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root){
        if(root==null)
            return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;

        int leftSum = maxSum(left);
        int rightSum = maxSum(right);

        int max1 = Math.max(Math.max(leftSum, rightSum)+root.val, root.val);

        int max2 =  Math.max(max1, rightSum+root.val+leftSum);

        max = Math.max(max2, max);

        return max1;
    }
}
