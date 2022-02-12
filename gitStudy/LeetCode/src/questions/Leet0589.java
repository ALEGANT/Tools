class Leet0589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        return traverse(root, res);
    }

    public List<Integer> traverse(Node root, List<Integer> res){
        res.add(root.val);
        if(root.children.size() == 0) return res;
        else {
            for(Node node: root.children){
                traverse(node, res);
            }
            return res;
        }
    }
}