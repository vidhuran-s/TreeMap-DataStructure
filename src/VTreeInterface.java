import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public interface VTreeInterface<V extends Comparable<V>, D> {

    void insert(V key, D value);

    void inOrder();

    VEntry<V, D> get(V key);

    ArrayList<VEntry<V, D>> getEntries();

    ArrayList<V> getKeys();

    ArrayList<D> getValues();

    void remove(V key);

    boolean contain(V key);

    boolean contain(V key, D value);

    void replace(V key, D value);

    void insertBulk(LinkedHashSet<V> keys, ArrayList<D> values);

    void insertBulk(LinkedHashSet<V> keys, LinkedList<D> values);

    void insertBulk(LinkedHashSet<V> keys, D[] values);

    void insertBulk(VEntry<V, D>[] entries);

    void insertBulk(V[] keys, D[] values);

    boolean isEmpty();

    void printAll();

    boolean clear();
}
