package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.CrossDirection;
import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.util.TestUtil;

public class WaitingInQueueStateTestCase extends BaseStateTestCase {

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

	@Test
	public void monkeyCanNotChangeStateBecauseIsNotFirstMonkeyInQueue() {
		Monkey firtMonkey = new Monkey(CrossDirection.EASTWARD);
		Monkey secondMonkey = new Monkey(CrossDirection.EASTWARD);

		MonkeyFactory.getEastwardqueue().addMonkey(firtMonkey);
		MonkeyFactory.getEastwardqueue().addMonkey(secondMonkey);

		Assert.assertEquals(WaitingInQueueState.class, firtMonkey.getState().getClass());

		// State not change.
		Assert.assertEquals(secondMonkey.getState(), secondMonkey.getState().handle());

		// Now first monkey advance.

		Assert.assertEquals(TryingGetRopeState.class, firtMonkey.getState().handle().getClass());

		// Now second monkey can advance
		Assert.assertEquals(TryingGetRopeState.class, secondMonkey.getState().handle().getClass());

	}

}
