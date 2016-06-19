package com.monkeys.deepcanyon.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

public class Rope {

	private final int westwardFirstPosition;
	private final int eastwardFirstPosition = 0;

	private final int length;

	private final ConcurrentLinkedQueue<Monkey> monkeys = new ConcurrentLinkedQueue<Monkey>();

	private final AtomicReference<Monkey> tryingGetRopeMonkey = new AtomicReference<Monkey>();

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

	public boolean isEmpty() {
		return monkeys.isEmpty();
	}

	public Monkey getFirstMonkey() {
		return this.monkeys.peek();
	}

	public int getWestwardFirstPosition() {
		return westwardFirstPosition;
	}

	public int getEastwardFirstPosition() {
		return eastwardFirstPosition;
	}

	public AtomicReference<Monkey> getTryingGetRopeMonkey() {
		return tryingGetRopeMonkey;
	}

	public void reset() {
		this.monkeys.clear();
		this.tryingGetRopeMonkey.set(null);
	}

}
