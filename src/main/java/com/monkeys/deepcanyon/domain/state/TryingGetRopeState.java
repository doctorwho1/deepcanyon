package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.domain.Rope;

public class TryingGetRopeState extends BaseMonkeyState {

	public TryingGetRopeState(Monkey monkey, Rope rope) {
		super(monkey, rope);
	}

	public MonkeyState handle() {

		if (rope.getMonkeys().size() == 0
				|| this.areSameDirectionMonkeys(monkey, rope.getMonkeys().iterator().next().getMonkey())) {
			// FIXME: No estoy tratando correctamente los casos concurrentes.

			int currentMonkeyPosition;
			switch (monkey.getCrossDirection()) {
			case EASTWARD:
				currentMonkeyPosition = rope.getEastwardFirstPosition();
				break;
			case WESTWARD:
				currentMonkeyPosition = rope.getWestwardFirstPosition();
				break;
			default:
				throw new IllegalStateException("Monkey should have a cross direction");
			}

			rope.putMonkey(currentMonkeyPosition, monkey);
			return MonkeyFactory.createCrossingRopeState(this.monkey, currentMonkeyPosition);
		} else {
			// Can not get rope, monkeys in opposite direction.
			return MonkeyFactory.createWaitingInQueueState(monkey);
		}
	}

}
