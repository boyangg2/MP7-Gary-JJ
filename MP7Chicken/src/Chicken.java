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
		Scenes.chickenAttack();
		System.out.println("the chicken attacks " + p.getName() + "!");
		Scenes.wait(2);
		if (p.takeDamage(damage)) {
			Scenes.potatoDie();
			System.out.println("the chicken defeated " + p.getName() + "!");
			Scenes.wait(2);
			return true;
		} else {
			System.out.println("the chicken lowers " + p.getName()
				+ "'s health to " + p.getHealth() + "!");
			Scenes.wait(2);
			Scenes.chickenDie();
			System.out.println("but " + p.getName() + " instantly kills the chicken!");
			Scenes.wait(2);
			return false;
		}
	}
}
