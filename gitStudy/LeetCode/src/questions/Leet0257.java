class Leet0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        return traverse(root, list, "");
    }

    public List<String> traverse(TreeNode root, List<String> res, String element) {
        if(root.left == null && root.right == null) {
            res.add(element + root.val);
            return res;
        }
        else {
            if(root.left != null)traverse(root.left, res, element + root.val + "->");
            if(root.right != null)traverse(root.right, res, element + root.val + "->");
            return res;
        }
    }
}