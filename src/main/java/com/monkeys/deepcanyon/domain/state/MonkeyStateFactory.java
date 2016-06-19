package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyQueue;
import com.monkeys.deepcanyon.domain.Rope;

public final class MonkeyStateFactory {

	private static final int DEFAULT_ROPE_LENGTH = 4;

	private static final Rope ROPE = new Rope(MonkeyStateFactory.DEFAULT_ROPE_LENGTH);

	private static final MonkeyQueue eastwardQueue = new MonkeyQueue(CrossDirection.EASTWARD);

	private static final MonkeyQueue westwardQueue = new MonkeyQueue(CrossDirection.WESTWARD);

	public static final WaitingInQueueState createWaitingInQueueState(Monkey monkey) {
		switch (monkey.getCrossDirection()) {
		case EASTWARD:
			return MonkeyStateFactory.createWaitingInEastwardQueueState(monkey);
		case WESTWARD:
			return MonkeyStateFactory.createWaitingInWestwardQueueState(monkey);
		default:
			throw new IllegalStateException("Monkey should have a cross direction");
		}
	}

	public static final CrossingRopeState createCrossingRopeState(Monkey monkey, int currentRopePosition) {
		return new CrossingRopeState(monkey, MonkeyStateFactory.getRopeInstance(), currentRopePosition);
	}

	public static final GivingWayState createGivingWayState(Monkey monkey) {
		return new GivingWayState(monkey, MonkeyStateFactory.getRopeInstance());
	}

	public static final TryingGetRopeState createTryingGetRopeState(Monkey monkey) {
		return new TryingGetRopeState(monkey, MonkeyStateFactory.getRopeInstance());
	}

	public static final CrossedRopeState createCrossedRopeState(Monkey monkey) {
		return new CrossedRopeState(monkey, MonkeyStateFactory.getRopeInstance());
	}

	private static final WaitingInQueueState createWaitingInEastwardQueueState(Monkey monkey) {
		return new WaitingInQueueState(monkey, MonkeyStateFactory.getRopeInstance(), MonkeyStateFactory.eastwardQueue);
	}

	private static final WaitingInQueueState createWaitingInWestwardQueueState(Monkey monkey) {
		return new WaitingInQueueState(monkey, MonkeyStateFactory.getRopeInstance(), MonkeyStateFactory.westwardQueue);
	}

	private static final Rope getRopeInstance() {
		return MonkeyStateFactory.ROPE;
	}

}
