package com.monkeys.deepcanyon.domain;

public class MonkeyRopePosition {

	private Monkey monkey;
	private int position;

	public MonkeyRopePosition(Monkey monkey, int position) {
		super();
		this.monkey = monkey;
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonkeyRopePosition other = (MonkeyRopePosition) obj;
		if (position != other.position)
			return false;
		return true;
	}

	public Monkey getMonkey() {
		return monkey;
	}

	public int getPosition() {
		return position;
	}

}
