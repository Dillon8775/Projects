package characters;

public class TrickstersCharacter extends Character {

    @Override
    public int baseHealth() {
        return 80;
    }

    @Override
    public int baseAttackPower() {
        return 2;
    }

    @Override
    public String name() {
        return "Tricksters";
    }
}