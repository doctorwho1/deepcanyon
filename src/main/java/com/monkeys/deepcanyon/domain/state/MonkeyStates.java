package com.monkeys.deepcanyon.domain.state;

public final class MonkeyStates {

	public final static WaitingInQueueState WAITING_IN_QUEUE = new WaitingInQueueState();
	
	public final static CrossingRopeState CROSSING_ROPE = new CrossingRopeState();
	
	public final static GivingWayState GIVING_WAY = new GivingWayState();
	
	public final static TryingGetRopeState TRYING_GET_ROPE = new TryingGetRopeState();

}
