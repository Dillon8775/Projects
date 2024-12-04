public class PersonRunner {

    public static void main(String[] args) {
        Person person = new Person(16, "MALE", "Bobby", 6.2, false);
        System.out.println("Person is not able to drink!");
        person.setAge(21);
        if (person.getAge() >= 21) {
            System.out.println("Person is able to drink now!");
        }
        System.out.println("Person's name is " + person.getName() + ".");
        System.out.println("---");
        System.out.println(person);
    }
}