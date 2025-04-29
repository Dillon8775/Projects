package characters;

public class LeaderCharacter extends Character {

    @Override
    public int baseHealth() {
        return 98;
    }

    @Override
    public int baseAttackPower() {
        return 3;
    }

    @Override
    public String name() {
        return "Leader";
    }
}
