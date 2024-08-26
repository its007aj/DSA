/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
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
    int preIndex = 0;
    Map<Integer, Integer> m;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        if(n==1){
            return new TreeNode(inorder[0]);
        }

        preIndex = 0;

        m = new HashMap<>();
        for(int i=0; i<n; i++){
            m.put(inorder[i], i);
        }

        return pre(0, n-1, preorder, n);    
    }
    
    public TreeNode pre(int start, int end, int[] preorder, int size){
        if(preIndex>size)
            return null;

        int root = preorder[preIndex];
        int index = m.get(root);
        TreeNode parent = new TreeNode(root);

        if(start<=index-1){
            preIndex++;
            parent.left = pre(start, index-1, preorder, size);
        }
        
        if(index+1<=end){
            preIndex++;
            parent.right = pre(index+1, end, preorder, size);
        }
        

        return parent;
    }

}
