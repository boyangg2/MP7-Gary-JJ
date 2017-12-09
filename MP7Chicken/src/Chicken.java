// Gary, JJ 2017

public class Chicken {
	private int damage;
	private int weaponBonus;

	public Chicken() {

	}

	public Chicken(final int d, final int w) {
		damage = d;
		weaponBonus = w;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int d) {
		damage = d;
	}

	public void setWeaponBonus(int w) {
		damage += w;
	}

	public boolean attack(final Potato p) {
		return true;
	}
}
