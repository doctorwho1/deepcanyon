package com.monkeys.deepcanyon.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Rope {

	private final int westwardFirstPosition;
	private final int eastwardFirstPosition = 0;

	private final int length;

	private ConcurrentLinkedQueue<Monkey> monkeys = new ConcurrentLinkedQueue<Monkey>();

	public Rope(int length) {
		super();

		this.length = length;
		this.westwardFirstPosition = this.length - 1;
	}

	public int getLength() {
		return length;
	}

	public Collection<Monkey> getMonkeys() {
		return Collections.unmodifiableCollection(this.monkeys);
	}

	public Rope addMonkey(Monkey monkey) {

		this.monkeys.add(monkey);

		return this;
	}

	public void removeMonkey(Monkey monkey) {
		this.monkeys.remove(monkey);
	}
	
	public Monkey getFirstMonkey(){
		return this.monkeys.peek();
	}

	public int getWestwardFirstPosition() {
		return westwardFirstPosition;
	}

	public int getEastwardFirstPosition() {
		return eastwardFirstPosition;
	}

	public void reset() {
		this.monkeys.clear();
	}

}
