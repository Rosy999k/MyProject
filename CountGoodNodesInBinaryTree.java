class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        // test input
        if (root==null) return count;
        // start dfs
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode root, int val) {
        if (root==null) return;

        if (root.val >= val) count++;

        //  In exampe 1, from path 3->1->3 we send
        //     maximum value for comparision.
        //     Why? Because if we send 1 (i.e. don't
        //     send max value), we'll count 1 as the
        //     start of the path and increment count.
        //     This is not correct because we are not
        //     considering the already present maximum
        //     value (i.e. 3)
        dfs(root.left, Math.max(val, root.val));
        dfs(root.right, Math.max(val, root.val));
    }
}