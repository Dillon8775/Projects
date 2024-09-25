import java.util.*;

public class Sets {

    /**
     * <p>A {@link Set} is a way to group a bunch of like-objects into one unit. Similar to an ArrayList, but with important differences.
     */
    public static void main(String[] args) {
        // A set of Strings
        // A "Set" is an interface, not a normal class. So we must use "HashSet", similar to what we see in the Maps learning class.
        Set<String> names = new HashSet<>();

        names.add("Jerry");
        names.add("Carl");
        names.add("Walter");

        // Sets do not allow duplicates, unlike lists, which do.
        names.add("Jerry");

        // You can't remove an item from a Set using an index
        // If you remove "0", it's trying to remove the integer 0, not index 0.
        names.remove(0);

        // Lists maintain the correct in order that you add the elements in that list.
        // Sets don't do this, they have no particular order.
        System.out.println(names);
        System.out.println(names.size());

        boolean containsSaul = names.contains("Saul");
        if (containsSaul) {
            System.out.println("Found Saul!\n-----");
        } else {
            System.out.println("Couldn't find Saul. :(\n-----");
        }

        if (names.isEmpty()) {
            System.out.println("Set is empty!");
        }

        // One way to perform an action on each entry
        System.out.println("---");
        for (String name : names) {
            System.out.println(name);
        }

        // Another way to do the same thing
        System.out.println("____----");
        names.forEach(entry -> System.out.println(entry));

        // Another way to do it
        System.out.println("_-_-_-");
        names.forEach(System.out::println);

        // Another way to do it
        System.out.println("-----");
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }

        // List can contain duplicates. Sets cannot.
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(1);

        System.out.println("LIST: " + numberList);

        // Create a set of numbers, which will contain all the entries in the number LIST, but it will not contain duplicates.
        Set<Integer> numberSet = new HashSet<>();
        numberSet.addAll(numberList);
        System.out.println("SET:  " + numberSet);

        // A tree set is a set that will be ordered in their "correct" ordering.
        Set<String> treeSet = new TreeSet<>();
        treeSet.addAll(names);

        // A linked hash set that will be ordered in the order that they are added in.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(names);

        System.out.println("SET: " + names);
        System.out.println("TREE SET: " + treeSet);
        System.out.println("LINKED HASH SET: " + linkedHashSet);
    }
}