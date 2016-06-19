package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;

public class GivingWayState extends BaseMonkeyState {

	public GivingWayState(Monkey monkey, Rope rope) {
		super(monkey, rope);
	}

	public MonkeyState handle() {
		Monkey firstMonkey = this.rope.getFirstMonkey();

		if (firstMonkey == null || areSameDirectionMonkeys(monkey, firstMonkey)) {
			// Do nothing
			return this;
		} else {
			return MonkeyFactory.createWaitingInQueueState(monkey);
		}
	}

}
