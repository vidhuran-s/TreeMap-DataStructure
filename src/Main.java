import java.util.*;

public class Main {
    public static void main(String[] args) {
        VTree<Integer, String> myTree = new VTree<>();
//        myTree.insert(10, "A");
//        myTree.insert(10, "B");
//        myTree.insert(7, "C");
//        myTree.insert(4, "F");
//        myTree.insert(18, "G");
//        myTree.insert(12, "Z");
//
//        VEntry<Integer, String> entry = myTree.get(4);
//        System.out.println(entry.key + " - " + entry.value);
//
//        myTree.inOrder();
//        myTree.remove(10);
//        System.out.println("After deletion\n");
//        myTree.inOrder();

//        Contain Checking

//        boolean contain = myTree.contain(12);
//        boolean contains = myTree.contain(12, "z");
//        System.out.println("Is it contain ? " + (contain ? "Yes" : "No"));
//        System.out.println("Is it contains ? " + (contains ? "Yes" : "No"));

//        Replace checking

//        myTree.replace(11, "X");
//        System.out.println("After Replace\n");
//        myTree.inOrder();

//        Insert in Bulk
//        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
        Integer[] intArr = {28, 8, 42, 16, 2, 5, 33, 12, 21, 39, 1, 29, 6, 37, 44, 17, 13, 18, 19, 26, 14, 3, 9, 31, 7, 4, 11, 35, 25, 10, 24, 34, 41, 20, 30, 22, 43, 38, 40, 36, 23, 32, 15, 45, 100};
        Set<Integer> intSet = new HashSet<>(Arrays.asList(intArr));
        LinkedHashSet<Integer> intLSet = new LinkedHashSet<>(Arrays.asList(intArr));
        String[] strArr = {"Apple", "Banana", "Cherry", "Orange", "Grapes", "Pineapple", "Mango", "Peach", "Strawberry", "Blueberry", "Car", "Truck", "Bicycle", "Bus", "Train", "Airplane", "Boat", "Motorcycle", "Scooter", "Helicopter", "Laptop", "Tablet", "Smartphone", "Printer", "Monitor", "Keyboard", "Mouse", "Speaker", "Camera", "Headphones", "Chair", "Table", "Sofa", "Bed", "Cupboard", "Desk", "Bookshelf", "Lamp", "Mirror", "Clock", "Tree", "Flower", "River", "Mountain", "Ocean"};
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(strArr));

        long startTime = System.nanoTime();
        myTree.insertBulk(intArr, strArr);
        long endTime = System.nanoTime();
        System.out.println("After Bulk Insert\n");
        myTree.inOrder();

//        Getting all entries
        ArrayList<VEntry<Integer, String>> entries = myTree.getEntries();
        System.out.println("\n\nEntries Length: " + entries.size());

//        Getting all keys
        ArrayList<Integer> keys = myTree.getKeys();
        System.out.println("\n\nKeys Length");
        System.out.println(keys);

//        Getting all values
        ArrayList<String> values = myTree.getValues();
        System.out.println("\n\nValues Length");
        System.out.println(values);
        System.out.println("Time Taken - " + (endTime - startTime));

        startTime = System.nanoTime();
        myTree.insert(null, "Hello");
        endTime = System.nanoTime();

        System.out.println("Time Taken 2 - " + (endTime - startTime));
    }
}