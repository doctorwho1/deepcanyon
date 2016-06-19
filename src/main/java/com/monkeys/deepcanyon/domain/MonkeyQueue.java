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

	public CrossDirection getCrossDirection() {
		return crossDirection;
	}

}
