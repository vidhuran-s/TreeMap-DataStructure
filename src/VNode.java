public class VNode<V, D> {
    V key;
    D value;
    VNode<V, D> leftNode;
    VNode<V, D> rightNode;

    public VNode(V key, D value) {
        this.key = key;
        this.value = value;
    }
}
