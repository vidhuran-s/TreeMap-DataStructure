public class VBEntry<V, D> {
    V key;
    D value;

    public VBEntry(V key, D value) {
        this.key = key;
        this.value = value;
    }

    public V getKey() {
        return key;
    }

    public D getValue() {
        return value;
    }
}
