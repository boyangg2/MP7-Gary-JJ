// Gary, JJ 2017

public class Player {
	private String name;
	private long energy;

	public Player() {
	}

	public Player(final String n) {
		name = n;
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

	public boolean isAlive() {
		return energy > 0;
	}

	public void setEnergy(final long e) {
		if (e < 1000000000) {
			energy = e;
		} else {
			energy = 1000000000;
		}
	}

	public boolean useEnergy(final long e) {
		if ((energy - e) >= 0) {
			energy -= e;
			return true;
		}
		return false;
	}
}

