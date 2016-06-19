package com.monkeys.deepcanyon.domain.state;

import org.junit.Assert;
import org.junit.Test;

import com.monkeys.deepcanyon.domain.Monkey;
import com.monkeys.deepcanyon.domain.Rope;
import com.monkeys.deepcanyon.util.TestUtil;

public class GivingWayStateTestCase {

	@Test
	public void handleWestwardMonkeyRopeStillContainMonkeysInSameDirection() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		Rope rope = TestUtil.createEmptyRope().addMonkey(TestUtil.createWestwardMonkey());

		MonkeyState newMonkeyState = MonkeyStateFactory.createGivingWayState(monkey).handle(monkey, rope);

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleEastwardMonkeyRopeStillContainMonkeysInSameDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope().addMonkey(TestUtil.createEastwardMonkey());

		MonkeyState newMonkeyState = MonkeyStateFactory.createGivingWayState(monkey).handle(monkey, rope);

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleWestwardMonkeyRopeEmpty() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		Rope rope = TestUtil.createEmptyRope();

		MonkeyState newMonkeyState = MonkeyStateFactory.createGivingWayState(monkey).handle(monkey, rope);

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleEastwardMonkeyRopeEmpty() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope();

		MonkeyState newMonkeyState = MonkeyStateFactory.createGivingWayState(monkey).handle(monkey, rope);

		Assert.assertEquals(GivingWayState.class, newMonkeyState.getClass());

	}

	@Test
	public void handleWestwardMonkeyRopeStillContainMonkeysInOppositeDirection() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		Rope rope = TestUtil.createEmptyRope().addMonkey(TestUtil.createEastwardMonkey());

		MonkeyState newState = MonkeyStateFactory.createGivingWayState(monkey).handle(monkey, rope);

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

	}

	@Test
	public void handleEastwardMonkeyRopeStillContainMonkeysInOppositeDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope().addMonkey(TestUtil.createWestwardMonkey());

		MonkeyState newState = MonkeyStateFactory.createGivingWayState(monkey).handle(monkey, rope);

		Assert.assertEquals(WaitingInQueueState.class, newState.getClass());

	}

}
