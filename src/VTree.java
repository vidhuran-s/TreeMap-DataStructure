import java.util.*;

public class VTree<V extends Comparable<V>, D>{
     VNode<V, D> root = null;

    public void insert(V key, D value) {
        try {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null.");
            }
            root = insertRecursive(root, key, value);
        } catch (Exception e) {
            System.out.println("Error inserting key-value pair: " + e.getMessage());
        }
    }

    private VNode<V, D> insertRecursive(VNode<V, D> root, V key, D value) {
        if (root == null){
            root = new VNode<>(key, value);
        }
        else if (key.compareTo(root.key) < 0) {
            root.leftNode = insertRecursive(root.leftNode, key, value);
        }
        else if (key.compareTo(root.key) > 0) {
            root.rightNode = insertRecursive(root.rightNode, key, value);
        }
        else if (key.compareTo(root.key) == 0 ) {
            root.value = value;
        }

        return root;
    }

    public void inOrder() {
        try {
            if (root == null) {
                throw new IllegalStateException("Tree is empty.");
            }
            inOrderRecursive(root);
        } catch (Exception e) {
            System.out.println("Error at in-order traversal: " + e.getMessage());
        }
    }

    private void inOrderRecursive(VNode<V, D> root) {
        if (root != null) {
            inOrderRecursive(root.leftNode);
            System.out.println("Key - " + root.key + " Value - " + root.value);
            inOrderRecursive(root.rightNode);
        }
    }

    private void inOrderRecursive(VNode<V, D> root, ArrayList<VEntry<V, D>> entries) {
        if (root != null) {
            inOrderRecursive(root.leftNode, entries);
            entries.add(new VEntry<>(root.key, root.value));
            inOrderRecursive(root.rightNode, entries);
        }
    }
    
    public VEntry<V, D> get(V key){
        try {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null.");
            }
            return getRecursive(root, key);
        } catch (Exception e) {
            System.out.println("Error fetching key: " + e.getMessage());
            return null;
        }
    }

    private VEntry<V, D> getRecursive(VNode<V, D> root, V key) {
        VEntry<V, D> result = null;

        if (root == null) {
            System.out.println("No entry found with the given index");
            return null;
        }

        if (key.compareTo(root.key) == 0) {
            result = new VEntry<>(root.key, root.value);
        }
        else if (key.compareTo(root.key) > 0) {
            result = getRecursive(root.rightNode, key);
        }
        else if (key.compareTo(root.key) < 0) {
            result = getRecursive(root.leftNode, key);
        }
        return result;
    }

    public ArrayList<VEntry<V, D>> getEntries() {
        ArrayList<VEntry<V, D>> entries = new ArrayList<>();
        try {
            if (root == null) {
                throw new IllegalStateException("Tree is empty.");
            }
            inOrderRecursive(root, entries);
        } catch (Exception e) {
            System.out.println("Error fetching entries: " + e.getMessage());
        }
        return entries;
    }

    public ArrayList<V> getKeys() {
        ArrayList<VEntry<V, D>> entries = null;
        ArrayList<V> keys = new ArrayList<>();
        if (root != null) {
            entries = getEntries();
            for (int i = 0; i < entries.size(); i++) {
                keys.add(entries.get(i).key);
            }
            return keys;
        }
        return keys;
    }

    public ArrayList<D> getValues() {
        ArrayList<VEntry<V, D>> entries = null;
        ArrayList<D> values = new ArrayList<>();
        if (root != null) {
            entries = getEntries();
            for (int i = 0; i < entries.size(); i++) {
                values.add(entries.get(i).value);
            }
            return values;
        }
        return values;
    }

    public void remove(V key) {
        if (root != null) {
            removeRecursive(root, key);
        }
        else {
            System.out.println("No entry found with the given index");
        }
    }

    private VNode<V, D> removeRecursive(VNode<V, D> root, V key) {

        if (root == null) {
            System.out.println("No entry found with the given index");
            return null;
        }

        if (key.compareTo(root.key) == 0) {
            if ((root.leftNode == null) && (root.rightNode == null)) {
                return null;
            }
            else if (root.leftNode == null) {
                return root.rightNode;
            }
            else if (root.rightNode == null) {
                return root.leftNode;
            }
            else if ((root.leftNode != null) && (root.rightNode != null)) {
                VNode<V, D> next = min(root.rightNode);
                root.key = next.key;
                root.value = next.value;
                root.rightNode = removeRecursive(root.rightNode,  next.key);
            }
        }
        else if (key.compareTo(root.key) < 0) {
            root.leftNode = removeRecursive(root.leftNode, key);
        }
        else if (key.compareTo(root.key) > 0) {
            root.rightNode = removeRecursive(root.rightNode, key);
        }
        else {
            System.out.println("Node not found");
            return null;
        }
        return root;
    }

    public VNode<V, D> min(VNode<V, D> root) {
        while (root.leftNode != null) {
            root = root.leftNode;
        }
        return root;
    }

    public boolean contain(V key) {
        VEntry<V, D> result = null;
        if (root != null) {
            result = get(key);
            return (result != null) && (result.key.compareTo(key) == 0);
        }
        else {
            System.out.println("No entries found for the given key");
        }
        return false;
    }

    public boolean contain(V key, D value) {
        VEntry<V, D> result = null;
        if (root != null) {
            result = get(key);
            return (result != null) && ((result.key == key) && (result.value == value));
        }
        else {
            System.out.println("No entries found for the given key and values");
        }
        return false;
    }

    public void replace(V key, D value) {
        if (contain(key)) {
            insert(key, value);
        }
    }

    public void insertBulk(LinkedHashSet<V> keys, ArrayList<D> values) {
        if (keys.size() == values.size()) {
            ArrayList<V> givenSet = new ArrayList<>(keys);
            for (int i = 0; i < givenSet.size(); i++) {
                insert(givenSet.get(i), values.get(i));
            }
        }
    }

    public void insertBulk(LinkedHashSet<V> keys, LinkedList<D> values) {
        if (keys.size() == values.size()) {
            ArrayList<V> givenSet = new ArrayList<>(keys);
            for (int i = 0; i < givenSet.size(); i++) {
                insert(givenSet.get(i), values.get(i));
            }
        }
    }

    public void insertBulk(LinkedHashSet<V> keys, D[] values) {
        if (keys.size() == values.length) {
            ArrayList<V> givenSet = new ArrayList<>(keys);
            for (int i = 0; i < givenSet.size(); i++) {
                insert(givenSet.get(i), values[i]);
            }
        }
    }

    public void insertBulk(VEntry<V, D>[] entries) {
        for (int i = 0; i < entries.length; i++) {
            V key = entries[i].getKey();
            D value = entries[i].getValue();
            insert(key, value);
        }
    }

    public void insertBulk(V[] keys, D[] values) {
        if (keys.length == values.length) {
            for (int i = 0; i < keys.length; i++) {
                insert(keys[i], values[i]);
            }
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printAll() {
        printAllRecursive(root);
    }

    private void printAllRecursive(VNode<V, D> root) {
        if (root != null) {
            printAllRecursive(root.leftNode);
            System.out.println(root.value + " - " + root.key);
            printAllRecursive(root.rightNode);
        }
    }

    public boolean clear() {
        if (root != null) {
            root.leftNode = null;
            root.rightNode = null;
            root = null;
            return true;
        }
        else {
            System.out.println("The Tree is already empty");
        }
        return false;
    }
}