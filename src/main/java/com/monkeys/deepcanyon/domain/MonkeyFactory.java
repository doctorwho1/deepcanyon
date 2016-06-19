package com.monkeys.deepcanyon.domain;

import com.monkeys.deepcanyon.domain.state.CrossedRopeState;
import com.monkeys.deepcanyon.domain.state.CrossingRopeState;
import com.monkeys.deepcanyon.domain.state.GivingWayState;
import com.monkeys.deepcanyon.domain.state.TryingGetRopeState;
import com.monkeys.deepcanyon.domain.state.WaitingInQueueState;

public final class MonkeyFactory {

	private static final int DEFAULT_ROPE_LENGTH = 4;

	private static final Rope ROPE = new Rope(MonkeyFactory.DEFAULT_ROPE_LENGTH);

	private static final MonkeyQueue eastwardQueue = new MonkeyQueue(CrossDirection.EASTWARD);

	private static final MonkeyQueue westwardQueue = new MonkeyQueue(CrossDirection.WESTWARD);

	public static final void reset() {
		MonkeyFactory.ROPE.reset();
		MonkeyFactory.eastwardQueue.clear();
		MonkeyFactory.westwardQueue.clear();
	}

	public static final Monkey createMonkey(CrossDirection crossDirection) {
		Monkey monkey = new Monkey(crossDirection);
		switch (monkey.getCrossDirection()) {
		case EASTWARD:
			MonkeyFactory.eastwardQueue.addMonkey(monkey);
			break;
		case WESTWARD:
			MonkeyFactory.westwardQueue.addMonkey(monkey);
			break;
		}

		return monkey;
	}

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

	public static final CrossingRopeState createCrossingRopeState(Monkey monkey) {
		return new CrossingRopeState(monkey, MonkeyFactory.getRopeInstance());
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

	public static MonkeyQueue getEastwardqueue() {
		return eastwardQueue;
	}

	public static MonkeyQueue getWestwardqueue() {
		return westwardQueue;
	}

	private static final WaitingInQueueState createWaitingInEastwardQueueState(Monkey monkey) {
		return new WaitingInQueueState(monkey, MonkeyFactory.getRopeInstance(), MonkeyFactory.eastwardQueue);
	}

	private static final WaitingInQueueState createWaitingInWestwardQueueState(Monkey monkey) {
		return new WaitingInQueueState(monkey, MonkeyFactory.getRopeInstance(), MonkeyFactory.westwardQueue);
	}

}
