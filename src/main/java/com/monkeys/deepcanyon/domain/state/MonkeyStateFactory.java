package com.monkeys.deepcanyon.domain.state;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyQueue;

public final class MonkeyStateFactory {

	private static final MonkeyQueue eastwardQueue = new MonkeyQueue(CrossDirection.EASTWARD);

	private static final MonkeyQueue westwardQueue = new MonkeyQueue(CrossDirection.WESTWARD);

	public final static WaitingInQueueState createWaitingInQueueState(Monkey monkey) {
		switch (monkey.getCrossDirection()) {
		case EASTWARD:
			return MonkeyStateFactory.createWaitingInEastwardQueueState();
		case WESTWARD:
			return MonkeyStateFactory.createWaitingInWestwardQueueState();
		default:
			throw new IllegalStateException("Monkey should have a cross direction");
		}
	}

	private final static WaitingInQueueState createWaitingInEastwardQueueState() {
		return new WaitingInQueueState(MonkeyStateFactory.eastwardQueue);
	}

	private final static WaitingInQueueState createWaitingInWestwardQueueState() {
		return new WaitingInQueueState(MonkeyStateFactory.westwardQueue);
	}

	public final static CrossingRopeState createCrossingRopeState(int currentRopePosition) {
		return new CrossingRopeState(currentRopePosition);
	}

	public final static GivingWayState createGivingWayState() {
		return new GivingWayState();
	}

	public final static TryingGetRopeState createTryingGetRopeState() {
		return new TryingGetRopeState();
	}

	public final static CrossedRopeState createCrossedRopeState() {
		return new CrossedRopeState();
	}

}
