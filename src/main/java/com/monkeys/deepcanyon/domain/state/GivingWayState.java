package com.monkeys.deepcanyon.domain.state;

import java.util.Collection;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyRopePosition;
import com.monkeys.deepcanyon.domain.Rope;

public class GivingWayState extends BaseMonkeyState {

	public MonkeyState handle(Monkey monkey, Rope rope) {
		Collection<MonkeyRopePosition> ropeMonkeys = rope.getMonkeys();

		if (ropeMonkeys.isEmpty() || areSameDirectionMonkeys(monkey, ropeMonkeys.iterator().next().getMonkey())) {
			// Do nothing
			return this;
		} else {
			return MonkeyStates.WAITING_IN_QUEUE;
		}
	}

}
