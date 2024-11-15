public class Snack {
    private String name;
    private int calories;

    public Snack() {
        this.name = "";
        this.calories = 0;
    }

    public Snack(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}