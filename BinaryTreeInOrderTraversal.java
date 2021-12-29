// class Solution {
//             List<Integer> result = new ArrayList<>();

//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null) return result;

//         inorderTraversal(root.left);
//         result.add(root.val);
//         inorderTraversal(root.right);
//         return result;
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }
}