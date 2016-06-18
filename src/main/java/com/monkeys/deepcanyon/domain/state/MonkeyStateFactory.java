package com.monkeys.deepcanyon.domain.state;

public final class MonkeyStateFactory {

	public final static WaitingInQueueState createWaitingInQueueState() {
		return new WaitingInQueueState();
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
