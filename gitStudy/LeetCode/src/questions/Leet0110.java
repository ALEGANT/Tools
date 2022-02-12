class Leet0110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(deepth(root.left) - deepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int deepth(TreeNode root){
        if(root == null) return 0;
        else {
            int m = deepth(root.left) + 1;
            int n = deepth(root.right) + 1;
            if(m > n) return m; else return n;
        }
    }
}