/**
 1
 /   \                     lca(4,7) = 2
 2     3                    Traverse once find root , and store  O(N) O(N) to store both paths
 / \    / \
 4   5  8   9                 node 4 (1, 2, 4)  O(N) O(N) time and space
 / \                           node 7(1,2, 5, 7) O(N) O(N)
 6   7

 To improve space complexity  use recursive traversal techinque  where we move left , right ,dfs traversal
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else {// both left and right are not null, we found our result
            return root;
        }
    }
}
