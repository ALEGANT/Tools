public class test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(236, new TreeNode(104, null, new TreeNode(227, null, null)), new TreeNode(701, null, new TreeNode(911, null, null)));

        getMinimumDifference(root);

        Integer res = Integer.MAX_VALUE;
        traverse(root, res);
        System.out.println(res);
    }

    public static int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        return minDifference(root, root);
    }

    public static int minDifference(TreeNode node, TreeNode pre){
        if(node.left == null && node.right == null) return Math.abs(node.val - pre.val);
        int l = node.left != null ? minDifference(node.left, pre) : Integer.MAX_VALUE;
        int r = node.right != null ? minDifference(node.right, pre) : Integer.MAX_VALUE;
        return l < r ? l : r;
    }

    public static void traverse(TreeNode node, Integer res){
        if(node == null) return;
        traverse(node.left, res);
        if(node.left != null && node.val - node.left.val < res) res = node.val - node.left.val;
        traverse(node.right, res);
        if(node.right != null && node.val - node.right.val < res) res = node.right.val - node.val;
    }
}
