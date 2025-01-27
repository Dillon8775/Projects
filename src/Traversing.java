public class Traversing {

    public static void main(String[] args) {
        // Traversing an array means to access each element of an array.
        // Since an array is indexed from 0 to the number of elements -1, a standard for loop is a
        // convenient way to accomplish traversal of an array.
        int[] list = new int[5];
        for (int index = 0; index < list.length; index++) {
            list[index] = (int)(Math.random() * 10);
        }
    }
}