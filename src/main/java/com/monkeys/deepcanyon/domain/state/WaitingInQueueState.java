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

			if (this.existsMonkeysWaitingInOppositeQueue()
					&& this.areSameDirectionMonkeys(monkey, this.rope.getFirstMonkey())) {

				result = MonkeyFactory.createGivingWayState(this.monkey);

			} else {
				if (this.rope.getTryingGetRopeMonkey().compareAndSet(null, this.monkey)) {
					result = MonkeyFactory.createTryingGetRopeState(this.monkey);
					this.monkeyQueue.removeMonkey(monkey);
				}
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

	private boolean existsMonkeysWaitingInOppositeQueue() {
		if (this.monkeyQueue == MonkeyFactory.getEastwardqueue()) {
			return MonkeyFactory.getWestwardqueue().peekMonkey() != null;
		} else {
			return MonkeyFactory.getEastwardqueue().peekMonkey() != null;
		}
	}

}
