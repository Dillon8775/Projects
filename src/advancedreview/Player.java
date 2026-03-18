package advancedreview;

// Dillon C. Strickland
// 3/18/2025
// A player class containg a name and a score variable.
public class Player {
    private String name = "";
    private int score = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}