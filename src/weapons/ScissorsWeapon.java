package weapons;

public class ScissorsWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 6;
    }

    @Override
    public int durability() {
        return 51;
    }

    @Override
    public boolean hitInFactors() {
        return false;
    }
}