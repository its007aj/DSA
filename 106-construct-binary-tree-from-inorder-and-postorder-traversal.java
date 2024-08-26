/*
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=study-plan-v2&envId=top-interview-150
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
    Map<Integer, Integer> m;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==1){
            return new TreeNode(inorder[0]);
        }

        int n = inorder.length;
        m = new HashMap<>();
        for(int i=0; i<n; i++){
            m.put(inorder[i], i);
        }

        postIndex = n-1;

        return convert(0, n-1, postorder);

        
    }

    public TreeNode convert(int start, int end, int[] postorder){
        if(postIndex<0)
            return null;

        int root = postorder[postIndex];
        int index = m.get(root);
        TreeNode parent = new TreeNode(root);

        if(index+1<=end){
            postIndex--;
            parent.right = convert(index+1, end, postorder);
        }
            
        if(start<=index-1){
            postIndex--;
            parent.left = convert(start, index-1, postorder);
        }

        return parent;
    }


}
