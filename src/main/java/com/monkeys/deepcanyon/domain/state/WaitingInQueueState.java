package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.MonkeyQueue;
import com.monkeys.deepcanyon.domain.Rope;

public class WaitingInQueueState extends BaseMonkeyState {

	private MonkeyQueue monkeyQueue;

	public WaitingInQueueState(Monkey monkey, Rope rope, MonkeyQueue monkeyQueue) {
		super(monkey, rope);
		this.monkeyQueue = monkeyQueue;
	}

	public MonkeyState handle() {

		MonkeyState result = this;

		if (this.isFirtsMonkeyOnQueue()) {

			if (this.isRopeFull(rope)) {
				Monkey firstMonkey = this.rope.getFirstMonkey();
				if (this.areSameDirectionMonkeys(monkey, firstMonkey)) {
					result = MonkeyFactory.createGivingWayState(this.monkey);
				} else {
					// Do nothing
					return this;
				}

			} else {
				result = MonkeyFactory.createTryingGetRopeState(this.monkey);
				this.monkeyQueue.removeMonkey(monkey);
			}
		}

		return result;
	}

	public MonkeyQueue getMonkeyQueue() {
		return monkeyQueue;
	}

	private boolean isFirtsMonkeyOnQueue() {
		return this.monkeyQueue.peekMonkey().equals(this.monkey);
	}

}
