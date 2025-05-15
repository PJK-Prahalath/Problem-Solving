class Solution {
    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(final Node node, final Map<Integer, Node> nodes) {
        if (node == null) {
            return null;
        }
        if (nodes.containsKey(node.val)) {
            return nodes.get(node.val);
        }
        final var copy = new Node(node.val);
        nodes.put(copy.val, copy);
        node.neighbors.stream()
            .map(n -> clone(n, nodes))
            .forEach(copy.neighbors::add);
        return copy;
    }
}