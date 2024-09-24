package lambda;

public class Cat implements Printable {

    public String name;
    public int age;

    public Cat() {
    }

    @Override
    public void print(String suffix) {
        System.out.println("Meow");
    }
}