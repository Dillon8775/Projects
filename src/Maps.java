import java.util.HashMap;
import java.util.Map;

public class Maps {
    private static int timesPrinted = 1;

    /**
     * <p>Maps are sets of {@code key value pairs.}
     * <p>For example, lets create a HashMap of employee names and employee ids.
     * <p>Maps shouldn't be raw typed, they should be parameterized.
     * <p>Why do we use {@code "HashMap"} instead of {@code "Map"?} A {@code Map} is an {@code interface,} and the Map just specifies what kind of methods a real map implementation method should support. A {@code HashMap} is an implementation of a Map.
     */
    public static void main(String[] args) {
        // Our types must be class, not primitive types.
        Map<String, Integer> employeeIds = new HashMap<>();

        // Create an entry in our employeeIds HashMap, containing the name (String) of our employee, and their employee ID (Integer).
        employeeIds.put("John", 16272);
        employeeIds.put("Carl", 54321);
        employeeIds.put("Jerry", 1);

        // Print the employeeIds HashMap
        System.out.println(employeeIds);

        // Get the employee ID of Carl.
        int d = employeeIds.get("Carl");
        System.out.println("Carls Employee ID: "+d);

        // Check to see if a certain key exists in our HashMap
        boolean jerryExists = employeeIds.containsKey("Jerry");
        boolean georgeExists = employeeIds.containsKey("George");
        if (jerryExists) {
            System.out.println("Jerry exists!"); // <-- This prints because entry "Jerry" exists.
        } else {
            System.out.println("Oh, Jerry does not exist.");
        }

        if (georgeExists) {
            System.out.println("George exists!");
        } else {
            System.out.println("Oh, George does not exist."); // <-- This prints because entry "George" does not exist.
        }

        // Check to see if a certain value (in this case, Integer) exists in our HashMap
        boolean containsEmployeeId = employeeIds.containsValue(9);
        if (containsEmployeeId) {
            System.out.println("Found employee ID 9!");
        } else {
            System.out.println("Could not find an employee ID with 9.");
        }

        // Override our "John" entry with a new employee ID
        // If John doesn't exist, it creates it in the HashMap.
        employeeIds.put("John", 6821732);

        // "Replace" our Kramer entry with a new employee ID.
        // However, "Kramer" doesn't exist in our HashMap, therefor this line of code will do nothing.
        // We should instead use .put to create a new key in our map for "Kramer".
        employeeIds.replace("Kramer", 777);

        // Only puts this key in the HashMap if it does not already exist in the map.
        // If it does, it does nothing.
        employeeIds.putIfAbsent("Steve", 222);

        // Remove a key value pair from your HashMap.
        employeeIds.remove("Steve");

        // Prints out all Map keys and values.
        printMap(employeeIds);

        // If the specified key does not exist in the map, this returns the default value that you specify here.
        // In this case, "5" returns because Steve key does not exist.
        // It's a useful way to avoid null checks when retrieving values from a map.
        employeeIds.getOrDefault("Steve", 5);

        // Sets "Johns" employee ID to 10.
        employeeIds.compute("John", (key, value) -> 10);

        // Sets "Jerry"s value to null, removing it from the HashMap.
        employeeIds.compute("Jerry", (key, value) -> null);

        printMap(employeeIds);

        // Adds entry "Jerry" if it does not exist.
        // In this case, "Jerry" does not exist. So, "Jerry" is added with a value of 100.
        employeeIds.compute("Jerry", (key, value) -> value == null ? 100 : value);

        // Sets "Jerry"s key value to its current value * 2 (which is 2), because key "Jerry" exists.
        employeeIds.computeIfPresent("Jerry", (key, value) -> value * 2);

        employeeIds.put("Woahh", null);
        // Tries to set "Woahh"s key value to 100, but nothing happens because "Woahh"s key value is null.
        employeeIds.computeIfPresent("Woahh", (key, value) -> 100);

        // Function is applied because "Woahh" key exists in the map, but since the function returns "null", the key "B" is removed from the map.
        employeeIds.computeIfPresent("Woahh", (key, value) -> null);

        // "computeIfPresent" only modifies the entry if the key exists AND has a non-null value.
        // if the computation results in a null value, that key is removed from the map.
        // if the key is absent OR its value is null, then nothing happens.
        // Useful when you want to modify a map entry ONLY if it already exists and avoid creating new entries.

        printMap(employeeIds);

        // Since "Carl" already exists, nothing happens here.
        // If "Carl" didn't exist, then it's value would be replaced with 100.
        employeeIds.computeIfAbsent("Carl", (key) -> 100);
        printMap(employeeIds);

        // Since "Smackeo" doesn't exist, a new entry is created for it with a value of 614.
        employeeIds.computeIfAbsent("Smackeo", (key) -> 614);
        printMap(employeeIds);

        // When key is absent or its value is null, computeIfAbsent computes and inserts a new value.
        // If the key exists with a non-null value, it leaves it unchanged.
        // If the computed value is null, the key is not added to the map (or no change is made to an existing key)

        // Clears the HashMap of all entries.
        employeeIds.clear();

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // For each entry in a map, perform a certain action.
        // In this case, print the values of each key and display the key.
        // Similar to the for loop created at the bottom method in this class.
        map.forEach((key, value) -> System.out.println(key + "\t= " + value));

        // Clears the new map.
        printMapSimplified(map);
        map.clear();
    }

    /**
     * Print all entries with their respective values of any type of map.
     */
    private static void printMap(Map<?, ?> map) {
        System.out.println("---"+timesPrinted);
        for (Map.Entry<?, ?> m : map.entrySet()) {
            System.out.println(m.getKey() + ", " + m.getValue());
        }
        timesPrinted++;
    }

    private static void printMapSimplified(Map<?, ?> map) {
        System.out.println("_-_-_-_"+timesPrinted);
        map.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
        timesPrinted++;
    }
}