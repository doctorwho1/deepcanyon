package com.monkeys.deepcanyon.domain;

import java.util.concurrent.ConcurrentLinkedQueue;

import lombok.Builder;

public class MonkeyQueue {

	private ConcurrentLinkedQueue<Monkey> delegate = new ConcurrentLinkedQueue<Monkey>();
	private CrossDirection crossDirection;

	@Builder
	public MonkeyQueue(CrossDirection crossDirection) {
		super();
		this.crossDirection = crossDirection;
	}

	public void addMonkey(Monkey monkey) {
		this.delegate.offer(monkey);
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public Monkey peekMonkey() {
		return this.delegate.peek();
	}
	
	/**
	 * Retrieves and remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public Monkey pollMonkey() {
		return this.delegate.poll();
	}

	public CrossDirection getCrossDirection() {
		return crossDirection;
	}

}
