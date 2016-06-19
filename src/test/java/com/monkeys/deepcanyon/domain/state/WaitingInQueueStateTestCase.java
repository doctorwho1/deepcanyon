package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.util.TestUtil;

public class WaitingInQueueStateTestCase {

	@Before
	public void setUp() {
		MonkeyFactory.getRopeInstance().reset();
	}

	@Test
	public void handleEmptyRope() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyState newState = MonkeyFactory.createWaitingInQueueState(monkey).handle();

		Assert.assertEquals(TryingGetRopeState.class, newState.getClass());
	}

	@Test
	public void handleEastwardMonkeyFullRopeOfMonkeysInSameDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		TestUtil.createFullRopeOfEastwardMonkeys();
		MonkeyState newState = MonkeyFactory.createWaitingInQueueState(monkey).handle();

		Assert.assertEquals(GivingWayState.class, newState.getClass());

	}

	@Test
	public void handleEastwardMonkeyFullRopeOfMonkeysInOppositeDirection() {

		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		TestUtil.createFullRopeOfWestwardMonkeys();
		MonkeyState newState = MonkeyFactory.createWaitingInQueueState(monkey).handle();

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());
	}

}
