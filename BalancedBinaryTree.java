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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right))>1)  return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node) {/**
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
            public boolean isBalanced(TreeNode root) {
                if(root == null) return true;
                if(Math.abs(height(root.left) - height(root.right))>1)  return false;
                return isBalanced(root.left) && isBalanced(root.right);
            }

            public int height(TreeNode node) {
                if (node == null ) return 0;
                int left = height(node.left);
                int right = height(node.right);
                int bf = Math.abs(left- right);

                if(bf > 1 || left == -1 || right == -1) return -1;
                return 1+Math.max(left, right);
            }
        }
        if (node == null ) return 0;
        int left = height(node.left);
        int right = height(node.right);
        int bf = Math.abs(left- right);

        if(bf > 1 || left == -1 || right == -1) return -1;
        return 1+Math.max(left, right);
    }
}