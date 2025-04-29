package characters;

public abstract class Character {

    public abstract int baseHealth();

    public abstract int baseAttackPower();

    public abstract String name();

    public boolean isDead() {
        return false;
    }
}