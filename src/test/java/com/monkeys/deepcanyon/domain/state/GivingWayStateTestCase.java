package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.MonkeyFactory;
import com.monkeys.deepcanyon.util.TestUtil;

public class GivingWayStateTestCase extends BaseStateTestCase {

	@Test
	public void handleWestwardMonkeyRopeStillContainMonkeysInSameDirection() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		TestUtil.createEmptyRope().addMonkey(TestUtil.createWestwardMonkey());

		MonkeyState newMonkeyState = MonkeyFactory.createGivingWayState(monkey).handle();

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleEastwardMonkeyRopeStillContainMonkeysInSameDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		TestUtil.createEmptyRope().addMonkey(TestUtil.createEastwardMonkey());

		MonkeyState newMonkeyState = MonkeyFactory.createGivingWayState(monkey).handle();

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleWestwardMonkeyRopeEmpty() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		TestUtil.createEmptyRope();

		MonkeyState newMonkeyState = MonkeyFactory.createGivingWayState(monkey).handle();

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleEastwardMonkeyRopeEmpty() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		TestUtil.createEmptyRope();

		MonkeyState newMonkeyState = MonkeyFactory.createGivingWayState(monkey).handle();

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleWestwardMonkeyRopeStillContainMonkeysInOppositeDirection() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		TestUtil.createEmptyRope().addMonkey(TestUtil.createEastwardMonkey());

		MonkeyState newState = MonkeyFactory.createGivingWayState(monkey).handle();

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

	}

	@Test
	public void handleEastwardMonkeyRopeStillContainMonkeysInOppositeDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		TestUtil.createEmptyRope().addMonkey(TestUtil.createWestwardMonkey());

		MonkeyState newState = MonkeyFactory.createGivingWayState(monkey).handle();

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

	}

}
