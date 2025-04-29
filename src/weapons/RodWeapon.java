package weapons;

public class RodWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 6;
    }

    @Override
    public int durability() {
        return 57;
    }

    @Override
    public boolean hitInFactors() {
        return false;
    }
}