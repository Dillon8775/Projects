package enemies;

import weapons.ScissorsWeapon;
import weapons.Weapon;

public class WhiteEnemy extends Enemy {

    @Override
    public Weapon weapon() {
        return new ScissorsWeapon();
    }

    @Override
    public int baseHealth() {
        return 96;
    }

    @Override
    public int baseAttackPower() {
        return 3;
    }

    @Override
    public String name() {
        return "White Enemy";
    }
}