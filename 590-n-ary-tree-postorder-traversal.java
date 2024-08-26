/*
https://leetcode.com/problems/n-ary-tree-postorder-traversal/?envType=daily-question&envId=2024-08-26
*/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> post;

    public List<Integer> postorder(Node root) {
        post = new ArrayList<>();

        postOrder(root);
        return post;
    }

    public void postOrder(Node root){
        if(root==null)
            return;

        for(Node child: root.children){
            postOrder(child);
        }

        post.add(root.val);
        return;
    }
}
