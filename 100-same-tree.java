/*
https://leetcode.com/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> q1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> q2 = new ArrayDeque<>();

        if(p==null && q==null)
            return true;

        if((p!=null && q==null) || (p==null && q!=null))
            return false;

        if(p.val!=q.val)
            return false;

        q1.addLast(p);
        q2.addLast(q);

        while(!q1.isEmpty() || !q2.isEmpty()){
            
            TreeNode pHead = q1.removeFirst();
            TreeNode qHead = q2.removeFirst();

            if((pHead.left == null && qHead.left != null) || (pHead.left != null && qHead.left == null))
                return false;

            if((pHead.right != null && qHead.right == null) || (pHead.right == null && qHead.right != null))
                return false;

            if(pHead.left!=null && qHead.left!=null){
                if(pHead.left.val != qHead.left.val)
                    return false;
                q1.addLast(pHead.left);
                q2.addLast(qHead.left);
            }

            if(pHead.right!=null && qHead.right!=null){
                if(pHead.right.val != qHead.right.val)
                    return false;
                q1.addLast(pHead.right);
                q2.addLast(qHead.right);
            }

        }

        return true;
    }
}
