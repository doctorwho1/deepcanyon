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
		MonkeyState newState = MonkeyStates.WAITING_IN_QUEUE.handle(monkey, TestUtil.createEmptyRope());

		Assert.assertEquals(MonkeyStates.TRYING_GET_ROPE, newState);
	}

	@Test
	public void handleEastwardMonkeyFullRopeOfMonkeysInSameDirection() {
		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createFullRopeOfEastwardMonkeys();
		MonkeyState newState = MonkeyStates.WAITING_IN_QUEUE.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.GIVING_WAY, newState);

	}

	@Test
	public void handleEastwardMonkeyFullRopeOfMonkeysInOppositeDirection() {

		Monkey monkey = new Monkey(CrossDirection.EASTWARD);
		Rope rope = TestUtil.createFullRopeOfWestwardMonkeys();
		MonkeyState newState = MonkeyStates.WAITING_IN_QUEUE.handle(monkey, rope);

		Assert.assertEquals(MonkeyStates.WAITING_IN_QUEUE, newState);
		
	}

}
