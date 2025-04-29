package weapons;

public class CottonCandyWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 4;
    }

    @Override
    public int durability() {
        return 23;
    }

    @Override
    public boolean hitInFactors() {
        return true;
    }
}