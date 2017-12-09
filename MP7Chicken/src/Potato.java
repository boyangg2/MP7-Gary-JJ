// Gary, JJ 2017

public class Potato {
	private String name;
	private int health;

	public Potato() {
	}

	public Potato(final String n, final int h) {
		name = n;
		health = h;
	}

	public boolean takeDamage(final int d) {
		if ((health - d) >= 0) {
			health -= d;
			return false;
		}
		return true;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(final int h) {
		health = h;
	}

	public String getName() {
		return name;
	}

	public void setName(final String n) {
		name = n;
	}
}
