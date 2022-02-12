class Leet0111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return deepth(root);
    }

    public int deepth(TreeNode root){
        if(root.left == null && root.right == null) return 1;
        else {
            int l = root.left != null ? deepth(root.left) : Integer.MAX_VALUE;
            int r = root.right != null ? deepth(root.right) : Integer.MAX_VALUE;
            return Math.min(l, r) + 1;
        }
    }
}