package weapons;

public class SpaceGunWeapon extends Weapon {

    @Override
    public int attackPower() {
        return 78;
    }

    @Override
    public int durability() {
        return 80;
    }

    @Override
    public boolean hitInFactors() {
        return false;
    }
}