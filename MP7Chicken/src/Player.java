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

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(final int e) {
		energy = e;
	}

	public boolean useEnergy(final int e) {
		if ((energy - e) >= 0) {
			energy -= e;
			return true;
		}
		return false;
	}
}

