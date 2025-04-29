package enemies;

import characters.Character;
import weapons.Weapon;

public abstract class Enemy extends Character {

    public abstract Weapon weapon();
}