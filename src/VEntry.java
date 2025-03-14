import java.util.ArrayList;

public class VEntry<V, D> {
    V key;
    D value;

    public VEntry(V key, D value) {
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
