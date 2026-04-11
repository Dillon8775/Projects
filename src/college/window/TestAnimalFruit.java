package college.window;

// Dillon C. Strickland
// 3/27/2025
// Animals and fruit, each with different sounds and instructions on how to eat them.
public class TestAnimalFruit {

    public static void main(String[] args) {
        Object[] objects = {new Tiger(), new Chicken(), new Apple(), new Orange()};
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Edible) {
                System.out.println(((Edible)objects[i]).howToEat());
            }
            if (objects[i] instanceof Animal) {
                System.out.println(((Animal)objects[i]).sound());
            }
        }
    }

    public interface Edible {
        String howToEat();
    }

    public abstract static class Fruit implements Edible {
    }

    public abstract static class Animal {
        public abstract String sound();
    }

    public static class Apple extends Fruit {

        @Override
        public String howToEat() {
            return "Apple: Make apple cider";
        }
    }

    public static class Orange extends Fruit {

        @Override
        public String howToEat() {
            return "Orange: Make orange juice";
        }
    }

    public static class Tiger extends Animal {

        @Override
        public String sound() {
            return "Tiger: RROOAAARR";
        }
    }

    public static class Chicken extends Animal implements Edible {

        @Override
        public String sound() {
            return "Chicken: cock-a-doodle-doo";
        }

        @Override
        public String howToEat() {
            return "Chicken: Fry it";
        }
    }
}