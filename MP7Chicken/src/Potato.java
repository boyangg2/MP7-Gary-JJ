// Gary, JJ 2017

public class Potato {
	private String name;
	private long health;

	public Potato() {
	}

	public Potato(final String n, final long h) {
		name = n;
		health = h;
	}

	public boolean takeDamage(final long d) {
		if ((health - d) > 0) {
			health -= d;
			return false;
		}
		return true;
	}

	public long getHealth() {
		return health;
	}

	public void setHealth(final long h) {
		health = h;
	}

	public String getName() {
		return name;
	}

	public void setName(final String n) {
		name = n;
	}
}
