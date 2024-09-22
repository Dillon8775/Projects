import java.util.ArrayList;

public class Arrays {

    /**
     * <p>The difference between Arrays and ArrayLists.
     * <p>With Arrays, once they are created, their size cannot be changed.
     * <p>With {@link ArrayList}s, their size is not fixed, meaning that they can be increased/decreased.
     * <p>Arrays can hold {@code primitive types,} {@link ArrayList}s cannot.
     */
    public static void main(String[] args) {
        // This array will never grow or shrink from 4.
        String[] friends = new String[4];
        String[] friendsArray = {"Manny", "Landon", "John", "Eric"};

        // Prints "Landon"
        System.out.println(friendsArray[1]);

        // Prints the size of the friendsArray
        System.out.println(friendsArray.length);

        // You can't add an element to the end of an array because they have a fixed size. :(
        // You also can't remove elements, because they have a fixed size. :(

        // Assign index 0 (which is currently "Manny") to "Carl".
        friendsArray[0] = "Carl";

        // With array lists, you don't have to specify a size, because they don't have a fixed size.
        // They can expand and/or shrink constantly.
        ArrayList<String> blankArrayList = new ArrayList<>();
        ArrayList<String> friendsArrayList = new ArrayList<>(
                java.util.Arrays.asList("Manny", "Landon", "John", "Eric"));

        // Also prints "Landon"
        System.out.println(friendsArrayList.get(1));

        // Prints the size of the ArrayList
        System.out.println(friendsArrayList.size());

        // Add "Blobby" to the end of the list, then print that index (which is 4)
        friendsArrayList.add("Blobby");
        System.out.println(friendsArrayList.get(4));

        // Set the index 0 (currently "Manny") to "Carl".
        friendsArrayList.set(0, "Carl");

        // Remove index 2 in the array list (which is "John").
        friendsArrayList.remove(2);

        // Arrays are not as flexible as ArrayList.
        System.out.println("FRIENDS ARRAY: " + friendsArray);
        System.out.println("FRIENDS ARRAY LIST: " + friendsArrayList);

        // Print out each element in an Array.
        for (String name : friendsArray) {
            System.out.println("A: " + name);
        }

        // Print out each element in an ArrayList.
        friendsArrayList.forEach(element -> {
            System.out.println("AL: " + element);
        });
    }
}