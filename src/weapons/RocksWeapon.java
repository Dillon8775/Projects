package weapons;

public class RocksWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 9;
    }

    @Override
    public int durability() {
        return 60;
    }

    @Override
    public boolean hitInFactors() {
        return true;
    }
}