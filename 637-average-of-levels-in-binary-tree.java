/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/?envType=study-plan-v2&envId=top-interview-150
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

 class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
 }


class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        int i = 0;
        List<Double> ans = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        Double sum = 0.0;
        int num = 0;

        while(!q.isEmpty()){
            
            TreeNode node = q.peek().node;
            int level = q.peek().level;

            if(level == i){
                sum += node.val;
                num++;
                if(node.left!=null)
                    q.add(new Pair(node.left, level+1));
                if(node.right!=null)
                    q.add(new Pair(node.right, level+1));
                q.poll();
            }

            if(level == i+1){
                ans.add(sum/num);
                sum = 0.0;
                num = 0;
                i++;
            }

        }
        ans.add(sum/num);

        return ans;
    }
}
