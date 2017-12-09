// Gary, JJ 2017

public class Player {
	private String name;
	private long energy;

	public Player() {
	}

	public Player(final String n, final long e) {
		name = n;
		energy = e;
	}

	public String getName() {
		return name;
	}

	public void setName(final String n) {
		name = n;
	}

	public long getEnergy() {
		return energy;
	}

	public void setEnergy(final long e) {
		energy = e;
	}

	public boolean useEnergy(final long e) {
		if ((energy - e) >= 0) {
			energy -= e;
			return true;
		}
		return false;
	}
}

