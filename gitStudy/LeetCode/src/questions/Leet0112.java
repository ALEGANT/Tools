class Leet0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return traverse(root, 0, targetSum);
    }

    public boolean traverse(TreeNode root, int sum, int targetSum) {
        int curSum = root.val + sum;
        if(root.left == null && root.right == null) return (sum + root.val == targetSum);
        else {
            boolean l = root.left != null ? traverse(root.left, curSum, targetSum) : false;
            boolean r = root.right != null ? traverse(root.right, curSum, targetSum) : false;
            return l || r;
        }
    }
}