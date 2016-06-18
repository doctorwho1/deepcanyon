package com.monkeys.deepcanyon.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Rope {

	// invariant.
	private final int length;
	private Set<MonkeyRopePosition> positions = new HashSet<MonkeyRopePosition>();

	public Rope(int length) {
		super();

		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public Collection<MonkeyRopePosition> getMonkeys() {
		return Collections.unmodifiableCollection(this.positions);
	}

	public void putMonkey(int position, Monkey monkey) {

		this.positions.add(new MonkeyRopePosition(monkey, position));

		assert this.positions.size() <= this.length;
	}

}
