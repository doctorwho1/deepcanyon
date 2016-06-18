package com.monkeys.deepcanyon.domain;

import com.monkeys.deepcanyon.domain.state.MonkeyState;
import com.monkeys.deepcanyon.domain.state.MonkeyStateFactory;

import lombok.Builder;

public class Monkey {

	private CrossDirection crossDirection;

	private MonkeyState state;

	@Builder
	public Monkey(CrossDirection crossDirection) {
		super();

		if (crossDirection == null) {
			throw new IllegalArgumentException("crossDirection is required param");
		}

		this.state = MonkeyStateFactory.createWaitingInQueueState();
		this.crossDirection = crossDirection;
	}

	public CrossDirection getCrossDirection() {
		return crossDirection;
	}

	public MonkeyState getState() {
		return state;
	}

}
