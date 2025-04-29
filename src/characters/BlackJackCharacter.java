package characters;

public class BlackJackCharacter extends Character {

    @Override
    public int baseHealth() {
        return 87;
    }

    @Override
    public int baseAttackPower() {
        return 4;
    }

    @Override
    public String name() {
        return "Black Jack";
    }
}