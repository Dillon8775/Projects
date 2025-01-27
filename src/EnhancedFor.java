public class EnhancedFor {

    public static void main(String[] args) {
        int[] values = {14, 532, 7685, -123, 370};
        String[] words = {"testing", "woah", "uhh", "yesting", "yes", "no", "devouring"};

        for (int number : values) {
            System.out.println(number);
        }
        System.out.println("Finished!");

//        Object[] allTheThings = null;
//        for (Object currentThing : allTheThings) {
//            System.out.println(currentThing.toString());
//        }

        for (String s : words) {
            if (s.substring((s.length() - 3), (s.length())).equals("ing")) {
                System.out.println(s);
            }
        }
    }
}