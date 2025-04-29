package weapons;

public class ChopstickWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 5;
    }

    @Override
    public int durability() {
        return 61;
    }

    @Override
    public boolean hitInFactors() {
        return true;
    }
}