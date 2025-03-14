public class VBNode<V, D> {
    V key;
    D value;
    int height;
    VBNode<V, D> leftNode;
    VBNode<V, D> rightNode;

    public VBNode(V key, D value) {
        this.key = key;
        this.value = value;
        this.height = 1;
    }

    public int getHeight() {
        return height;
    }
}
