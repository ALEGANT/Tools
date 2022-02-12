class Leet0559 {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return deepth(root);
    }

    public int deepth(Node root) {
        if(root == null) return 0;
        else {
            int max = 0;
            for(Node node : root.children){
                int tmp = deepth(node);
                if(tmp > max) max = tmp;
            }
            return max + 1;
        }
    }

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
}