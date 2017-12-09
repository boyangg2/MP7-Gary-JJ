// Gary, JJ 2017

public class Chicken {
	private long damage;
	private long weaponBonus;

	public Chicken() {

	}

	public Chicken(final long d, final long w) {
		damage = d;
		weaponBonus = w;
	}

	public long getDamage() {
		return damage;
	}

	public void setDamage(final long d) {
		damage = d;
	}

	public void setWeaponBonus(final long w) {
		damage *= w;
	}

	public boolean attack(final Potato p) {
		return true;
	}
}
