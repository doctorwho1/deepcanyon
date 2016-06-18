package com.monkeys.deepcanyon.domain.state;

public final class MonkeyStateFactory {

	public final static WaitingInQueueState createWaitingInQueueState() {
		return new WaitingInQueueState();
	}

	public final static CrossingRopeState createCrossingRopeState() {
		return new CrossingRopeState();
	}

	public final static GivingWayState createGivingWayState() {
		return new GivingWayState();
	}

	public final static TryingGetRopeState createTryingGetRopeState() {
		return new TryingGetRopeState();
	}

}
