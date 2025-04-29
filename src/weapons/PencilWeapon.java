package weapons;

public class PencilWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 7;
    }

    @Override
    public int durability() {
        return 20;
    }

    @Override
    public boolean hitInFactors() {
        return false;
    }
}