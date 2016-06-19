package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.util.TestUtil;

public class WaitingInQueueStateTestCase {

	@Test
	public void handleEmptyRope() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		MonkeyState newState = MonkeyStateFactory.createWaitingInQueueState(monkey).handle(monkey,
				TestUtil.createEmptyRope());

		Assert.assertEquals(TryingGetRopeState.class, newState.getClass());
	}

	@Test
	public void handleEastwardMonkeyFullRopeOfMonkeysInSameDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createFullRopeOfEastwardMonkeys();
		MonkeyState newState = MonkeyStateFactory.createWaitingInQueueState(monkey).handle(monkey, rope);

		Assert.assertEquals(GivingWayState.class, newState.getClass());

	}

	@Test
	public void handleEastwardMonkeyFullRopeOfMonkeysInOppositeDirection() {

		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createFullRopeOfWestwardMonkeys();
		MonkeyState newState = MonkeyStateFactory.createWaitingInQueueState(monkey).handle(monkey, rope);

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());
	}

}
