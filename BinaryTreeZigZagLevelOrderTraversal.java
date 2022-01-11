/**
 * insert elements to q and keep a flag to change the direction
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        if(root == null)
        {
            return wrapList;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int  levelNo = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i< levelNo;i++){
                TreeNode node= q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(flag) {
                    subList.add(0, node.val);
                }
                else
                    subList.add(node.val);
            }

            wrapList.add(subList);
            flag = !flag;
        }
        return wrapList;
    }
}