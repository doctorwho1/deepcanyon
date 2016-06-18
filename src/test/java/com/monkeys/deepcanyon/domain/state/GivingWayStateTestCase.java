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

		MonkeyState newMonkeyState = MonkeyStates.GIVING_WAY.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.GIVING_WAY, newMonkeyState);

	}

	@Test
	public void handleEastwardMonkeyRopeStillContainMonkeysInSameDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope().addMonkey(TestUtil.createEastwardMonkey());

		MonkeyState newMonkeyState = MonkeyStates.GIVING_WAY.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.GIVING_WAY, newMonkeyState);

	}

	@Test
	public void handleWestwardMonkeyRopeEmpty() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		Rope rope = TestUtil.createEmptyRope();

		MonkeyState newMonkeyState = MonkeyStates.GIVING_WAY.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.GIVING_WAY, newMonkeyState);

	}

	@Test
	public void handleEastwardMonkeyRopeEmpty() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope();

		MonkeyState newMonkeyState = MonkeyStates.GIVING_WAY.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.GIVING_WAY, newMonkeyState);

	}

	@Test
	public void handleWestwardMonkeyRopeStillContainMonkeysInOppositeDirection() {
		Monkey monkey = TestUtil.createWestwardMonkey();
		Rope rope = TestUtil.createEmptyRope().addMonkey(TestUtil.createEastwardMonkey());

		MonkeyState newMonkeyState = MonkeyStates.GIVING_WAY.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.WAITING_IN_QUEUE, newMonkeyState);

	}

	@Test
	public void handleEastwardMonkeyRopeStillContainMonkeysInOppositeDirection() {
		Monkey monkey = TestUtil.createEastwardMonkey();
		Rope rope = TestUtil.createEmptyRope().addMonkey(TestUtil.createWestwardMonkey());

		MonkeyState newMonkeyState = MonkeyStates.GIVING_WAY.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.WAITING_IN_QUEUE, newMonkeyState);

	}

}
