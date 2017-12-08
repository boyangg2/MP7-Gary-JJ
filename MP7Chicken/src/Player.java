// Gary, JJ 2017

public class Player {
	private String name;
	private int energy;

	public Player() {

	}

	public Player(final String n, final int e) {
		name = n;
		energy = e;
	}

	public String getName() {
		return name;
	}

	public void setName(final String n) {
		name = n;
	}
}