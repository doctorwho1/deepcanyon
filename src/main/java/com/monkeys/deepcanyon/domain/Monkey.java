package com.monkeys.deepcanyon.domain;

import com.monkeys.deepcanyon.domain.state.MonkeyState;
import com.monkeys.deepcanyon.domain.state.MonkeyStates;

public class Monkey {

	private CrossDirection crossDirection;

	private MonkeyState state;

	public Monkey(CrossDirection crossDirection) {
		super();
		this.state = MonkeyStates.WAITING_IN_QUEUE;
		this.crossDirection = crossDirection;
	}

	public CrossDirection getCrossDirection() {
		return crossDirection;
	}

	public MonkeyState getState() {
		return state;
	}

}
