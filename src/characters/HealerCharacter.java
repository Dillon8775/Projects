package characters;

public class HealerCharacter extends Character {

    @Override
    public int baseHealth() {
        return 76;
    }

    @Override
    public int baseAttackPower() {
        return 2;
    }

    @Override
    public String name() {
        return "Healer";
    }
}