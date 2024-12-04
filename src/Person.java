// An "abstract" class, as a person.
public class Person {
    // Our instance variables
    private int age;
    private String gender;
    private String name;
    private double height;
    private boolean employed;

    // Constructor for the Person class
    // Contains an age, gender, name, height, and employed (true or false).
    // Instance variables are declared when we create a new instance of the Person class.
    // When we declare a new instance, we assign the variables through the constructors parameters.
    // Those passed arguments are then set to the proper variable within that instance of the object.
    public Person(int age, String gender, String name, double height, boolean employed) {
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.height = height;
        this.employed = employed;
    }

    // Mutator methods
    // Allow us to modify the object's instance variables, without calling the actual variables
    // These methods return the object's instance variables, so we can get or set their values.

    // Getters and setters
    // Getters allow us to get the current value of an object's instance variable.
    // A getter method returns the current value of the object's variable.
    // Setters allow us to get the current value of an object's instance variable and change it.
    // A setter method typically has a parameter to be passed through to change the current value of the instance variable.
    // Setter methods are typically void, but sometimes they may return something.

    // Writing methods
    // You can write methods which pass in parameters to return values or change or add things to your class
    // For example, you can write a method to check two "Dog" classes, to see if they are the same breed
    // public boolean doBreedMatch(Dog dog1, Dog dog2) {
    //      return dog1.getBreed() == dog2.getBreed();
    // }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isEmployed() {
        return this.employed;
    }

    @Override
    public String toString() {
        return "PERSON\n" +
                "Age: " + this.getAge()+
                "\n"+
                "Gender: " + this.getGender()+
                "\n"+
                "Name: " + this.getName()+
                "\n"+
                "Height: " + this.getHeight()+
                "\n"+
                "Employed: " + (this.isEmployed() ? "Yes" : "No");
    }
}