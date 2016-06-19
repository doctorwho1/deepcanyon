package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyQueue;
import com.monkeys.deepcanyon.domain.Rope;

public class WaitingInQueueState extends BaseMonkeyState {

	private MonkeyQueue monkeyQueue;

	public WaitingInQueueState(MonkeyQueue monkeyQueue) {
		super();
		this.monkeyQueue = monkeyQueue;
	}

	public MonkeyState handle(Monkey monkey, Rope rope) {
		if (this.isRopeFull(rope)) {
			if (this.areSameDirectionMonkeys(monkey, rope.getMonkeys().iterator().next().getMonkey())) {
				return MonkeyStateFactory.createGivingWayState();
			} else {
				// Do nothing
				return this;
			}

		} else {
			return MonkeyStateFactory.createTryingGetRopeState();
		}

	}

}
