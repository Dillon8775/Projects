package weapons;

public class BladeWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 8;
    }

    @Override
    public int durability() {
        return 76;
    }

    @Override
    public boolean hitInFactors() {
        return false;
    }
}