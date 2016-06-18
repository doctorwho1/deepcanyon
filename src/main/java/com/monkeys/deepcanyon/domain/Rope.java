package com.monkeys.deepcanyon.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Rope {

	// invariant.
	private final int westwardFirstPosition;
	private final int eastwardFirstPosition = 0;

	private final int length;
	private Set<MonkeyRopePosition> positions = new HashSet<MonkeyRopePosition>();

	public Rope(int length) {
		super();

		this.length = length;
		this.westwardFirstPosition = this.length - 1;
	}

	public int getLength() {
		return length;
	}

	public Collection<MonkeyRopePosition> getMonkeys() {
		return Collections.unmodifiableCollection(this.positions);
	}
	
	public Monkey getMonkey(int position){
		
		for (MonkeyRopePosition each : this.positions){
			if (each.getPosition() == position){
				return each.getMonkey();
			}
		}
		
		return null;
	}

	/**
	 * 
	 * @param monkey
	 * @return
	 * @deprecated borrar este método.
	 */
	public Rope addMonkey(Monkey monkey) {
		switch (monkey.getCrossDirection()) {
		case EASTWARD:
			this.putMonkey(this.eastwardFirstPosition, monkey);
			break;
		case WESTWARD:
			this.putMonkey(this.westwardFirstPosition, monkey);
			break;
		default:
			throw new IllegalStateException("Monkey should have a cross direction");
	
		}

		return this;
	}

	public int getWestwardFirstPosition() {
		return westwardFirstPosition;
	}

	public int getEastwardFirstPosition() {
		return eastwardFirstPosition;
	}

	public void putMonkey(int position, Monkey monkey) {

		this.positions.add(new MonkeyRopePosition(monkey, position));

		assert this.positions.size() <= this.length;
	}

}
