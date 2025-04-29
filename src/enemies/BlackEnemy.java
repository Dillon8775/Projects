package enemies;

import weapons.BladeWeapon;
import weapons.Weapon;

public class BlackEnemy extends Enemy {

    @Override
    public Weapon weapon() {
        return new BladeWeapon();
    }

    @Override
    public int baseHealth() {
        return 97;
    }

    @Override
    public int baseAttackPower() {
        return 3;
    }

    @Override
    public String name() {
        return "Black Dude";
    }
}