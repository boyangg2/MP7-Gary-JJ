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
		health -= d;
		return (health <= 0);
	}

	public String getName() {
		return name;
	}

	public void setName(final String n) {
		name = n;
	}
}
