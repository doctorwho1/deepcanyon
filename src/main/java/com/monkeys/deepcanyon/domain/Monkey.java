package com.monkeys.deepcanyon.domain;

import java.util.UUID;

import com.monkeys.deepcanyon.domain.state.MonkeyState;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Monkey {

	private String monkeyName = UUID.randomUUID().toString();

	private CrossDirection crossDirection;

	private MonkeyState state;

	@Builder
	public Monkey(CrossDirection crossDirection) {
		super();

		if (crossDirection == null) {
			throw new IllegalArgumentException("crossDirection is required param");
		}

		this.crossDirection = crossDirection;
		this.state = MonkeyFactory.createWaitingInQueueState(this);
		
		log.info("Monkey arrived: "+this);

	}

	/**
	 * The monkey thinks and executes the next action.
	 */
	public void think() {
		this.state = this.state.handle();
	}

	public CrossDirection getCrossDirection() {
		return crossDirection;
	}

	public MonkeyState getState() {
		return state;
	}

	@Override
	public String toString() {
		return "Monkey [monkeyName=" + monkeyName + ", crossDirection=" + crossDirection + ", state=" + state + "]";
	}
	
	

}
