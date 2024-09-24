package filewriter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Learning how to write and read files, while also utilizing {@link Map}s and {@code for} loops.
 */
public class FileIO {

    public static void main(String[] args) /* <-- We add throws IOException */ {
        String fileName = "output.txt";

        String[] names = {"John", "Carl", "Manny"};
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            System.out.println("Writing to file...");
            writer.write("Hello!");
            writer.write("\nHere, is another line!\n");

            // Print each name in an array
            for (String name : names) {
                writer.write("\n" + name);
            }

            writer.close(); // <-- Close the file writer
            System.out.println("Finished writing!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            Map<String, Integer> lineNumber = new HashMap<>();

            String line;
            int i = 0;
            boolean isMannyPresent = false;
            boolean isSmackeoPresent = false;

            // Line equals reader.readLine until it equals null, then the loop stops and exits.
            while ((line = reader.readLine()) != null) {
                if (line.equals("Manny")) {
                    isMannyPresent = true;
                    lineNumber.put("Manny", i);
                }
                if (line.equals("Smackeo")) {
                    isSmackeoPresent = true;
                    lineNumber.put("Smackeo", i);
                }
                System.out.println(line);
                i++;
            }

            if (isMannyPresent) {
                System.out.println("Found Manny on line " + lineNumber.get("Manny") + "!");
            }
            if (isSmackeoPresent) {
                System.out.println("Found Smackeo on line " + lineNumber.get("Smackeo"));
            } else {
                // You wouldn't typically do this, but this is just to practice catch statements.
                throw new NullPointerException();
            }

            reader.close(); // <-- Close the file reader
        } catch (IOException e) {
            e.printStackTrace();
            // Catch our NullPointerException
        } catch (NullPointerException e) {
            // Handle the exception
            System.out.println("Couldn't find Smackeo! :(");
        }
    }
}