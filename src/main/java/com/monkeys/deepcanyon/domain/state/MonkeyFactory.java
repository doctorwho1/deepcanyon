package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyQueue;
import com.monkeys.deepcanyon.domain.Rope;

public final class MonkeyFactory {

	private static final int DEFAULT_ROPE_LENGTH = 4;

	private static final Rope ROPE = new Rope(MonkeyFactory.DEFAULT_ROPE_LENGTH);

	private static final MonkeyQueue eastwardQueue = new MonkeyQueue(CrossDirection.EASTWARD);

	private static final MonkeyQueue westwardQueue = new MonkeyQueue(CrossDirection.WESTWARD);

	public static final WaitingInQueueState createWaitingInQueueState(Monkey monkey) {
		switch (monkey.getCrossDirection()) {
		case EASTWARD:
			return MonkeyFactory.createWaitingInEastwardQueueState(monkey);
		case WESTWARD:
			return MonkeyFactory.createWaitingInWestwardQueueState(monkey);
		default:
			throw new IllegalStateException("Monkey should have a cross direction");
		}
	}

	public static final CrossingRopeState createCrossingRopeState(Monkey monkey, int currentRopePosition) {
		return new CrossingRopeState(monkey, MonkeyFactory.getRopeInstance(), currentRopePosition);
	}

	public static final GivingWayState createGivingWayState(Monkey monkey) {
		return new GivingWayState(monkey, MonkeyFactory.getRopeInstance());
	}

	public static final TryingGetRopeState createTryingGetRopeState(Monkey monkey) {
		return new TryingGetRopeState(monkey, MonkeyFactory.getRopeInstance());
	}

	public static final CrossedRopeState createCrossedRopeState(Monkey monkey) {
		return new CrossedRopeState(monkey, MonkeyFactory.getRopeInstance());
	}

	public static final Rope getRopeInstance() {
		return MonkeyFactory.ROPE;
	}

	private static final WaitingInQueueState createWaitingInEastwardQueueState(Monkey monkey) {
		return new WaitingInQueueState(monkey, MonkeyFactory.getRopeInstance(), MonkeyFactory.eastwardQueue);
	}

	private static final WaitingInQueueState createWaitingInWestwardQueueState(Monkey monkey) {
		return new WaitingInQueueState(monkey, MonkeyFactory.getRopeInstance(), MonkeyFactory.westwardQueue);
	}

}
