package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;

public class WaitingInQueueState extends BaseMonkeyState {

	public MonkeyState handle(Monkey monkey, Rope rope) {
		if (this.isRopeFull(rope)) {
			if (this.areSameDirectionMonkeys(monkey, rope.getMonkeys().iterator().next().getMonkey())) {
				return MonkeyStates.GIVING_WAY;
			} else {
				return MonkeyStates.WAITING_IN_QUEUE;
			}

		} else {
			return MonkeyStates.TRYING_GET_ROPE;
		}

	}

}
